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

Плагин для базовой логики Android в модуле приложения

- Настройка android плагина для application
- Настройка compileSdk, targetSdk, minSdk
- Настройка buildTypes
- Настройка зависимостей
- Настройка proguard
- Настройка signingConfigs

#### com.yugyd.buildlogic.android.library

Плагин для базовой логики Android в модуле библиотеки

- Настройка android плагина для library
- Настройка compileSdk, targetSdk, minSdk
- Настройка buildTypes
- Настройка зависимостей

#### com.yugyd.buildlogic.kotlin.jvm

Плагин для базовой логики kotlin модуля библиотеки JVM

- Настройка kotlin плагина
- Настройка зависимостей

**Build Types**

#### com.yugyd.buildlogic.application.buildtype

Плагин для конфигурации build types Android Application и отключения неиспользуемых product flavor
вариантов.

#### com.yugyd.buildlogic.library.buildtype

Плагин для конфигурации build types Android Library и отключения неиспользуемых product flavor
вариантов.

#### com.yugyd.buildlogic.buildtype.apk.version

Плагин для добавления статических version значений в debug APK для производильности сборки.

**Compose**

#### com.yugyd.buildlogic.application.compose

Плагин для настройки Jetpack Compose в Android Application (compiler metrics, версия компилятора,
BOM и preview зависимости).

- Настройка зависимостей Compose
- Настройка компилятора Compose
- Настройка опций Compose
- Добавление отчета производительности Compose

#### com.yugyd.buildlogic.library.compose

Плагин для настройки Jetpack Compose в Android Library (compiler metrics, версия компилятора, BOM и
preview зависимости).

- Настройка зависимостей Compose
- Настройка компилятора Compose
- Настройка опций Compose
- Добавление отчета производительности Compose

**Jacoco**

#### com.yugyd.buildlogic.application.jacoco

Плагин для настройки Jacoco в Android Application (toolVersion, отчёты, excludes).

- Настройка Jacoco для юнит тестов

#### com.yugyd.buildlogic.library.jacoco

Плагин для настройки Jacoco в Android Library (toolVersion, отчёты, excludes).

- Настройка Jacoco для юнит тестов

#### com.yugyd.buildlogic.kotlin.jacoco

Плагин для настройки Jacoco в kotlin JVM модуле (toolVersion, отчёты, excludes).

- Настройка Jacoco для юнит тестов

**Lint**

#### com.yugyd.buildlogic.application.lint

Плагин для настройки Android Lint в Application модуле (disables, abortOnError, warningsAsErrors и
др.).

- Настройка правил lint
- Настройка отчетов lint
- Настройка исключений lint

#### com.yugyd.buildlogic.library.lint

Плагин для настройки Android Lint в Library модуле (disables, abortOnError, warningsAsErrors и др.).

- Настройка правил lint
- Настройка отчетов lint
- Настройка исключений lint

#### com.yugyd.buildlogic.kotlin.lint

Плагин для настройки Lint в kotlin JVM модуле.

- Настройка правил lint
- Настройка отчетов lint
- Настройка исключений lint

**Publish**

#### com.yugyd.buildlogic.library.publish

Плагин для публикации Android Library в Maven репозитории.

- Настройка публикации в Maven репозиторий
- Настройка метаданных публикации
- Настройка подписания артефактов
- Настройка публикации исходников и javadoc

#### com.yugyd.buildlogic.kotlin.publish

Плагин для публикации kotlin JVM библиотеки в Maven репозитории.

- Настройка публикации в Maven репозиторий
- Настройка метаданных публикации
- Настройка подписания артефактов
- Настройка публикации исходников и javadoc

#### com.yugyd.buildlogic.platform.publish

Плагин для публикации Java Platform (BOM) в Maven репозитории.

- Настройка и публикация bom файла

**Test**

#### com.yugyd.buildlogic.application.test

Плагин для настройки тестов Android Application (instrumentation runner, test options).

- Настройка юнит тестов
- Настройка инструментальных тестов
- Настройка зависимостей тестирования

#### com.yugyd.buildlogic.library.test

Плагин для настройки тестов Android Library (instrumentation runner, test options).

- Настройка юнит тестов
- Настройка инструментальных тестов
- Настройка зависимостей тестирования

**Tools**

#### com.yugyd.buildlogic.detekt

Плагин для настройки Detekt и статического анализа кода.

- Настройка правил detekt
- Настройка отчетов detekt
- Настройка исключений detekt

**Требования:**

Наличие конфигурационного файла detekt, если его нет `./gradlew detektGenerateConfig`

#### com.yugyd.buildlogic.dependency.updates

Плагин для проверки обновлений зависимостей.

#### com.yugyd.buildlogic.hilt

Плагин для подключения Hilt (plugin, зависимости и KSP компилятор).

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
