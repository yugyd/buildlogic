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

package com.yugyd.buildlogic.convention.lint

import com.android.build.api.dsl.Lint
import com.yugyd.buildlogic.convention.core.KOTLIN_JVM_ALIAS
import com.yugyd.buildlogic.convention.core.LINT_ALIAS
import com.yugyd.buildlogic.convention.core.checkPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class LintJvmKotlinPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            checkPlugin(KOTLIN_JVM_ALIAS)
            plugins.apply(LINT_ALIAS)

            extensions.configure<Lint> {
                configureLint()
            }
        }
    }
}
