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

package com.yugyd.buildlogic.convention.jacoco

import com.yugyd.buildlogic.convention.core.JACOCO_ALIAS
import com.yugyd.buildlogic.convention.core.KOTLIN_JVM_ALIAS
import com.yugyd.buildlogic.convention.core.checkPlugin
import com.yugyd.buildlogic.convention.core.findPluginId
import com.yugyd.buildlogic.convention.core.libs
import com.yugyd.buildlogic.convention.jacoco.core.configureJacocoInTasks
import com.yugyd.buildlogic.convention.jacoco.core.configureReportsAndSourceDirs
import com.yugyd.buildlogic.convention.jacoco.core.createCustomJacocoCoverageExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.getByName
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoReport

class JacocoKotlinJvmPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            checkPlugin(KOTLIN_JVM_ALIAS)
            pluginManager.apply(libs.findPluginId(JACOCO_ALIAS))

            extensions.configure(JacocoPluginExtension::class.java) {
                toolVersion = libs.findVersion("jacoco").get().toString()
            }

            configureJvmJacoco()

            val extension = createCustomJacocoCoverageExtension()
            configureJacocoInTasks(extension)

            tasks.withType(Test::class.java).configureEach {
                extensions.configure(JacocoTaskExtension::class.java) {
                    // https://github.com/gradle/gradle/issues/5184#issuecomment-457865951
                    isIncludeNoLocationClasses = true
                    excludes = listOf("jdk.internal.*")
                }
            }
        }
    }

    private fun Project.configureJvmJacoco() {
        val buildDir = layout.buildDirectory.get().asFile

        tasks.getByName(name = "jacocoTestReport", type = JacocoReport::class) {
            val testTask = tasks.getByName("test")
            dependsOn(testTask)

            configureReportsAndSourceDirs(this@configureJvmJacoco)

            val execFile = file("$buildDir/jacoco/test.exec")
            executionData.setFrom(execFile)
        }
    }
}
