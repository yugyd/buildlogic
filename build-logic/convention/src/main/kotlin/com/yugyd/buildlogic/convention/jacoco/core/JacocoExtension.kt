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

import com.android.build.api.variant.AndroidComponentsExtension
import com.yugyd.buildlogic.convention.core.libs
import org.gradle.api.Project
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.register
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoCoverageVerification
import org.gradle.testing.jacoco.tasks.JacocoReport
import java.util.Locale

internal fun Project.configureJacocoAndroid(
    androidComponentsExtension: AndroidComponentsExtension<*, *, *>,
    extension: CustomJacocoCoverageExtension,
) {
    extensions.configure(JacocoPluginExtension::class.java) {
        toolVersion = libs.findVersion("jacoco").get().toString()
    }

    val jacocoTestReport = tasks.register("jacocoTestReport", JacocoReport::class)

    androidComponentsExtension.onVariants { variant ->
        val testTaskName = "test${variant.name.capitalize()}UnitTest"

        val reportTask = createAndroidReportTask(
            testTaskName = testTaskName,
            variantName = variant.name,
            extension = extension,
        )

        jacocoTestReport.configure {
            dependsOn(reportTask)
        }
    }

    tasks.withType(Test::class.java).configureEach {
        extensions.configure(JacocoTaskExtension::class.java) {
            // https://github.com/gradle/gradle/issues/5184#issuecomment-457865951
            isIncludeNoLocationClasses = true
            excludes = listOf("jdk.internal.*")
        }
    }
}

private fun Project.createAndroidReportTask(
    testTaskName: String,
    variantName: String,
    extension: CustomJacocoCoverageExtension,
): TaskProvider<JacocoReport> {
    val buildDir = layout.buildDirectory.get().asFile

    val reportTask = tasks.register(
        name = "jacoco${testTaskName.capitalize()}Report",
        type = JacocoReport::class,
    ) {
        dependsOn(testTaskName)

        configureReportsAndSourceDirs(this@createAndroidReportTask)

        val tmpKotlinFileTree = fileTree("$buildDir/tmp/kotlin-classes/$variantName") {
            exclude(coverageExclusions)
        }
        classDirectories.setFrom(tmpKotlinFileTree)

        val execFile = file("$buildDir/jacoco/$testTaskName.exec")
        executionData.setFrom(execFile)

        setClassDirectories(
            target = this@createAndroidReportTask,
            extension = extension,
        )
    }

    return reportTask
}

private val coverageExclusions = listOf(
    "**/R.class",
    "**/R\$*.class",
    "**/BuildConfig.*",
    "**/Manifest*.*"
)

private fun String.capitalize() = replaceFirstChar {
    if (it.isLowerCase()) {
        it.titlecase(Locale.getDefault())
    } else {
        it.toString()
    }
}

internal fun Project.configureAndroidJacocoInTasks(
    androidComponentsExtension: AndroidComponentsExtension<*, *, *>,
    extension: CustomJacocoCoverageExtension,
) {
    configureJacocoInTestTask(extension)
    configureJacocoInJacocoTestCoverageVerification(androidComponentsExtension, extension)
}

private fun Project.configureJacocoInJacocoTestCoverageVerification(
    androidComponentsExtension: AndroidComponentsExtension<*, *, *>,
    extension: CustomJacocoCoverageExtension,
) {
    val jacocoTestVerification = tasks.register(
        name = "jacocoTestCoverageVerification",
        type = JacocoCoverageVerification::class,
    )

    androidComponentsExtension.onVariants { variant ->
        val testTaskName = "test${variant.name.capitalize()}UnitTest"

        val verificationTask = createAndroidVerificationTask(
            testTaskName = testTaskName,
            variantName = variant.name,
            extension = extension,
        )

        jacocoTestVerification.configure {
            dependsOn(verificationTask)

            configCoverageVerification(
                target = this@configureJacocoInJacocoTestCoverageVerification,
                extension = extension,
            )
        }
    }
}

private fun Project.createAndroidVerificationTask(
    testTaskName: String,
    variantName: String,
    extension: CustomJacocoCoverageExtension,
): TaskProvider<JacocoCoverageVerification> {
    val buildDir = layout.buildDirectory.get().asFile

    val verificationTask = tasks.register(
        name = "jacoco${testTaskName.capitalize()}CoverageVerification",
        type = JacocoCoverageVerification::class,
    ) {
        dependsOn(testTaskName)

        configureSourceDirs(this@createAndroidVerificationTask)

        val tmpKotlinFileTree = fileTree("$buildDir/tmp/kotlin-classes/$variantName") {
            exclude(coverageExclusions)
        }
        classDirectories.setFrom(tmpKotlinFileTree)

        val execFile = file("$buildDir/jacoco/$testTaskName.exec")
        executionData.setFrom(execFile)

        configCoverageVerification(
            target = this@createAndroidVerificationTask,
            extension = extension,
        )
    }

    return verificationTask
}
