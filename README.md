Android Build Logic
===================

This project contains build logic for Android and Kotlin Multiplatform (KMP) multi-module projects.

* **Ease of use.** Connect and apply with a single line in build.gradle.kts.
* **Unified configuration.** All modules use the same settings.
* **Save time on routine tasks.** Automation and basic module configuration are centralized in one
  place.
* **Extensibility.** Easily add your own plugins in your project’s includeBuild by overriding
  settings.
* **Up-to-date.** Dependencies and build tools are continuously updated.
* **New features.** Plugins are expanded to support new tasks and capabilities.
* **Improved build performance.** Optimizations and best Gradle/Android practices applied.
* **Better code quality.** Integration of static analyzers and test coverage tools.

[Gradle documentation](https://docs.gradle.org/current/userguide/implementing_gradle_plugins_convention.html)

Further development based on the repository for
building [Gradle projects for Android.](https://github.com/yugyd/buildlogic)

# Build logic

## Introductory requirements

- Gradle: 8.14.3+
- Android Gradle Plugin: 8.10.1+.
- Kotlin: 1.9.25+
- Compile SDK: 35
- Target SDK: 35
- Min SDK: 24
- Detekt: 1.23.6+

## How is the AGP version selected?

The plugins are developed targeting the third release version of Android Studio and the Android
Gradle Plugin (AGP).

For example, there are three versions, and the third one at the end is Meerkat. Meerkat uses the
latest AGP version 8.10.1. We use AGP version 8.10.1 accordingly.

- Otter
- Narwhal
- **Meerkat** (target version)

[See more](https://developer.android.com/build/releases/gradle-plugin#android_gradle_plugin_and_android_studio_compatibility)

## Build logic plugins

**Core**

#### com.yugyd.buildlogic.android.application

Plugin for Basic Android Logic in the App Module

- Configure the Android plugin for the application
- Set `compileSdk`, `targetSdk`, and `minSdk`
- Configure `buildTypes`
- Set up dependencies
- Configure ProGuard
- Set up `signingConfigs`

#### com.yugyd.buildlogic.android.library

Plugin for Basic Android Logic in the Library Module

- Configure the Android plugin for the library
- Set `compileSdk`, `targetSdk`, and `minSdk`
- Configure `buildTypes`
- Set up dependencies

#### com.yugyd.buildlogic.kotlin.jvm

Plugin for Basic Kotlin Logic in the JVM Library Module

- Configure the Kotlin plugin
- Set up dependencies

**Build Types**

#### com.yugyd.buildlogic.application.buildtype

Plugin for Configuring Build Types in Android Application and Disabling Unused Product Flavor
Variants.

#### com.yugyd.buildlogic.library.buildtype

Plugin for Configuring Build Types in Android Library and Disabling Unused Product Flavor Variants

#### com.yugyd.buildlogic.buildtype.apk.version

Plugin for adding static version values to Debug APK for build performance

**Compose**

#### com.yugyd.buildlogic.application.compose

Plugin for Configuring Jetpack Compose in Android Application *(compiler metrics, compiler version,
BOM, and preview dependencies)*

- Set up Compose dependencies
- Configure the Compose compiler
- Configure Compose options
- Add Compose performance report

#### com.yugyd.buildlogic.library.compose

Plugin for Configuring Jetpack Compose in Android Library *(compiler metrics, compiler version, BOM,
and preview dependencies)*

- Set up Compose dependencies
- Configure the Compose compiler
- Configure Compose options
- Add Compose performance report

**Jacoco**

#### com.yugyd.buildlogic.application.jacoco

Plugin for Configuring Jacoco in Android Application *(toolVersion, reports, excludes)*

- Configure Jacoco for unit tests

#### com.yugyd.buildlogic.library.jacoco

Plugin for Configuring Jacoco in Android Library *(toolVersion, reports, excludes)*

- Configure Jacoco for unit tests

#### com.yugyd.buildlogic.kotlin.jacoco

Plugin for Configuring Jacoco in Kotlin JVM Module *(toolVersion, reports, excludes)*

- Configure Jacoco for unit tests

**Lint**

#### com.yugyd.buildlogic.application.lint

Plugin for Configuring Android Lint in Application Module *(disables, abortOnError,
warningsAsErrors, etc.)*

- Configure lint rules
- Configure lint reports
- Configure lint exclusions

#### com.yugyd.buildlogic.library.lint

Plugin for Configuring Android Lint in Library Module *(disables, abortOnError, warningsAsErrors,
etc.)*

- Configure lint rules
- Configure lint reports
- Configure lint exclusions

#### com.yugyd.buildlogic.kotlin.lint

Plugin for Configuring Lint in Kotlin JVM Module

- Configure lint rules
- Configure lint reports
- Configure lint exclusions

**Publish**

#### com.yugyd.buildlogic.library.publish

Plugin for Publishing Android Library to Maven Repository

- Configure publishing to Maven repository
- Configure publication metadata
- Configure artifact signing
- Configure publishing of sources and Javadoc

#### com.yugyd.buildlogic.kotlin.publish

Plugin for Publishing Kotlin JVM Library to Maven Repository

- Configure publishing to Maven repository
- Configure publication metadata
- Configure artifact signing
- Configure publishing of sources and Javadoc

#### com.yugyd.buildlogic.platform.publish

Plugin for Publishing Java Platform (BOM) to Maven Repository

- Configure and publish the BOM file

**Test**

#### com.yugyd.buildlogic.application.test

Plugin for Configuring Tests in Android Application *(instrumentation runner, test options)*

- Configure unit tests
- Configure instrumentation tests
- Configure testing dependencies

#### com.yugyd.buildlogic.library.test

Plugin for Configuring Tests in Android Library *(instrumentation runner, test options)*

- Configure unit tests
- Configure instrumentation tests
- Configure testing dependencies

**Tools**

#### com.yugyd.buildlogic.detekt

Plugin for Configuring Detekt and Static Code Analysis

- Configure Detekt rules
- Configure Detekt reports
- Configure Detekt exclusions

**Requirements:**

A Detekt configuration file must be present. If it is missing, run:

```bash
./gradlew detektGenerateConfig
```

#### com.yugyd.buildlogic.dependency.updates

Plugin for Checking Dependency Updates.

#### com.yugyd.buildlogic.hilt

Plugin for Integrating Hilt *(plugin, dependencies, and KSP compiler)*

# Commands

To validate a Plugin Portal publication (no upload):

https://docs.gradle.org/current/userguide/publishing_gradle_plugins.html#sec:publishing_your_plugin

```bash
./gradlew :build-logic:convention:validatePlugins
```

# Sample project

- Typical Android app
- Jvm library
- Android library
- Java platform (BOM)

## Base project file structure

- app: main project configuration, application build
- build-logic: project build logic
- docs: accompanying documentation for the project
- gradle: everything related to gradle is the wrapper and libs directory
- product: the project code base, here is all the functionality of the application
- sample-app: project configuration of dependencies that a developer needs to develop a feature

## Stack template project

* Language: Kotlin
* Architecture: MVVM (Google), clean, multi-module
* UI: Compose, Material 3
* Navigation: Jetpack Compose Navigation
* DI: Hilt
* Testing: Coming Soon!

## Build types

`debug` - Logging, debug mode, proguard off.

`release` - No logging, no debug mode, proguard enabled.

# Contributions

[Guide](docs/CONTRIBUTION.md)

# License

```
   Copyright 2025 Roman Likhachev

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
