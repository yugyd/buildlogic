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

package com.yugyd.buildlogic.convention.detekt

import com.yugyd.buildlogic.convention.core.DETEKT_ALIAS
import com.yugyd.buildlogic.convention.core.libs
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType

class DetektPlugin : Plugin<Project> {

    private val Project.detektBaselinePath get() = "$rootDir/detekt-baseline.xml"
    private val Project.detektConfigPath get() = "$rootDir/detekt-config.yml"

    override fun apply(target: Project) {
        with(target) {
            plugins.apply(DETEKT_ALIAS)

            extensions.configure<DetektExtension> {
                parallel = true
                config.setFrom(detektConfigPath)
                buildUponDefaultConfig = true
                baseline = file(detektBaselinePath)
            }

            // Set reports
            tasks.withType(Detekt::class) {
                reports {
                    html.required.set(true)
                    xml.required.set(true)
                    txt.required.set(true)
                }
            }

            // Add auto-correct
            dependencies {
                add(
                    "detektPlugins",
                    libs.findLibrary("detekt-formatting").get()
                )
            }

            createGenerateBaselineTask()
        }
    }

    private fun Project.createGenerateBaselineTask() {
        tasks.register(
            "detektProjectBaseline",
            DetektCreateBaselineTask::class,
        ) {
            baseline.set(file(detektBaselinePath))
            buildUponDefaultConfig.set(true)
            config.setFrom(files(detektConfigPath))
            description = "Overrides current baseline."
            parallel.set(true)
            setSource(files(rootDir))
            include("**/*.kt")
            include("**/*.kts")
            exclude("**/resources/**")
            exclude("**/build/**")
        }
    }
}
