/*
 *    Copyright 2024 Roman Likhachev
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.yugyd.buildlogic.convention.core

import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import org.gradle.plugins.signing.SigningExtension

internal fun Project.configureMavenInfo() {
    group = project.property("ARTIFACT_GROUP").toString()
    version = project.findProperty("ARTIFACT_VERSION")?.toString()
        ?: rootProject.property("ARTIFACT_VERSION").toString()
}

internal fun Project.configureMavenRepositories() {
    extensions.configure<PublishingExtension> {
        repositories {
            maven {
                val releasesRepoUrl = getReleaseRepository(this@configureMavenRepositories)
                val snapshotsRepoUrl = getSnapshotRepository(this@configureMavenRepositories)

                val isSnapshotVersion = version.toString().endsWith("SNAPSHOT")

                url = if (
                    !snapshotsRepoUrl.isNullOrBlank() && !releasesRepoUrl.isNullOrBlank()
                ) {
                    credentials {
                        username = getRepositoryUsername(this@configureMavenRepositories)
                        password = getRepositoryPassword(this@configureMavenRepositories)
                    }

                    uri(
                        if (isSnapshotVersion) {
                            snapshotsRepoUrl
                        } else {
                            releasesRepoUrl
                        }
                    )
                } else {
                    uri(
                        if (isSnapshotVersion) {
                            layout.buildDirectory.dir("repos/snapshots")
                        } else {
                            layout.buildDirectory.dir("repos/releases")
                        }
                    )
                }
            }
        }
    }
}

private fun getRepositoryUsername(target: Project): String? =
    System.getenv("REPO_USERNAME")
        ?: target.findStringProperty("REPO_USERNAME")

private fun getRepositoryPassword(target: Project): String? =
    System.getenv("REPO_PASSWORD")
        ?: target.findStringProperty("REPO_PASSWORD")

private fun getSnapshotRepository(target: Project): String? =
    System.getenv("REPO_SNAPSHOT_URL")
        ?: target.findStringProperty("REPO_SNAPSHOT_URL")

private fun getReleaseRepository(target: Project): String? =
    System.getenv("REPO_RELEASE_URL")
        ?: target.findStringProperty("REPO_RELEASE_URL")

internal fun Project.configureMavenPublishing(packagingName: String, componentName: String) {
    extensions.configure<PublishingExtension> {
        publications {
            register<MavenPublication>(componentName) {
                artifactId = project.name

                pom {
                    packaging = packagingName

                    name.set(stringProperty("POM_NAME"))
                    description.set(stringProperty("POM_DESCRIPTION"))
                    url.set(stringProperty("POM_URL"))

                    licenses {
                        license {
                            name.set(stringProperty("POM_LICENSE_NAME"))
                            url.set(stringProperty("POM_LICENSE_URL"))
                            distribution.set(stringProperty("POM_LICENCE_DIST"))
                        }
                    }

                    developers {
                        developer {
                            id.set(stringProperty("POM_DEVELOPER_ID"))
                            name.set(stringProperty("POM_DEVELOPER_NAME"))
                            email.set(stringProperty("POM_DEVELOPER_EMAIL"))
                        }
                    }

                    scm {
                        connection.set(stringProperty("POM_SCM_CONNECTION"))
                        developerConnection.set(stringProperty("POM_SCM_DEVELOPER_CONNECTION"))
                        url.set(stringProperty("POM_SCM_URL"))
                    }
                }

                afterEvaluate {
                    from(components[componentName])
                }
            }
        }
    }

    configureSigning()
}

internal fun Project.configureSigning() {
    extensions.configure<SigningExtension> {
        useInMemoryPgpKeys(
            System.getenv("SIGNING_KEY_ID"),
            System.getenv("SIGNING_KEY"),
            System.getenv("SIGNING_PASSWORD")
        )

        extensions.configure<PublishingExtension> {
            sign(publications)
        }
    }
}
