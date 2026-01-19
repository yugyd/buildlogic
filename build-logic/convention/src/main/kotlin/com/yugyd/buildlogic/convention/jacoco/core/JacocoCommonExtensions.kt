/*
 *    Copyright 2025 Roman Likhachev
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

package com.yugyd.buildlogic.convention.jacoco.core

import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoCoverageVerification
import org.gradle.testing.jacoco.tasks.JacocoReport
import org.gradle.testing.jacoco.tasks.JacocoReportBase

internal fun JacocoReport.configureReportsAndSourceDirs(project: Project) {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }

    configureSourceDirs(project)
}

internal fun JacocoReportBase.configureSourceDirs(project: Project) {
    val sourceSetFiles = project.files(
        "${project.projectDir}/${SourceSets.JAVA}",
        "${project.projectDir}/${SourceSets.KOTLIN}",
    )
    sourceDirectories.setFrom(sourceSetFiles)
}

internal fun Project.configureJacocoInTasks(extension: CustomJacocoCoverageExtension) {
    configureJacocoInTestTask(extension)
    configureJacocoInJacocoTestReportTask(extension)
    configureJacocoInJacocoTestCoverageVerification(extension)
}

internal fun Project.configureJacocoInTestTask(extension: CustomJacocoCoverageExtension) {
    tasks.withType<Test>().configureEach {
        configure<JacocoTaskExtension> {
            excludes = excludes?.plus(extension.jacocoExclusion.get())
            includes = includes?.plus(extension.jacocoInclusion.get())
        }
    }
}

private fun Project.configureJacocoInJacocoTestReportTask(
    extension: CustomJacocoCoverageExtension,
) {
    tasks.getByName(name = "jacocoTestReport", type = JacocoReport::class) {
        setClassDirectories(
            target = this@configureJacocoInJacocoTestReportTask,
            extension = extension,
        )
    }
}

internal fun JacocoReportBase.setClassDirectories(
    target: Project,
    extension: CustomJacocoCoverageExtension,
) {
    classDirectories.setFrom(
        target.files(
            classDirectories.files.map {
                target.fileTree(it) {
                    setExcludes(excludes.plus(extension.jacocoExclusion.get()))
                    setIncludes(includes.plus(extension.jacocoInclusion.get()))
                }
            }
        )
    )
}

private fun Project.configureJacocoInJacocoTestCoverageVerification(
    extension: CustomJacocoCoverageExtension,
) {
    tasks.getByName(
        "jacocoTestCoverageVerification",
        JacocoCoverageVerification::class,
    ) {
        configCoverageVerification(
            target = this@configureJacocoInJacocoTestCoverageVerification,
            extension = extension,
        )
    }
}

internal fun JacocoCoverageVerification.configCoverageVerification(
    target: Project,
    extension: CustomJacocoCoverageExtension,
) {
    setClassDirectories(
        target = target,
        extension = extension,
    )

    violationRules {
        rule {
            limit {
                val minCoverageLimit = project.providers
                    .gradleProperty(
                        "jacocoMinCoverageLimit",
                    ).orNull
                    ?: extension.customJacocoCoveragePercent.orNull
                    ?: JacocoParams.MINIMUM_LIMIT

                minimum = minCoverageLimit.toBigDecimal()
            }

            limit {
                counter = "BRANCH"

                val minCoverageLimit = project.providers
                    .gradleProperty(
                        "jacocoMinCoverageBranchLimit",
                    ).orNull
                    ?: extension.customJacocoCoverageBranchPercent.orNull
                    ?: JacocoParams.MINIMUM_BRANCH_LIMIT

                minimum = minCoverageLimit.toBigDecimal()
            }
        }
    }
}

fun Project.createCustomJacocoCoverageExtension(): CustomJacocoCoverageExtension {
    val extension = extensions.create<CustomJacocoCoverageExtension>("customJacocoCoverage")
    extension.customJacocoCoveragePercent.convention(JacocoParams.MINIMUM_LIMIT)
    extension.customJacocoCoverageBranchPercent.convention(JacocoParams.MINIMUM_BRANCH_LIMIT)
    extension.jacocoExclusion.convention(JacocoParams.DEFAULT_EXCLUSION)
    extension.jacocoInclusion.convention(JacocoParams.DEFAULT_INCLUSION)
    return extension
}
