import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    alias(libs.plugins.plugin.publish)
    signing
}

group = project.group
version = project.version

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    withJavadocJar()
    withSourcesJar()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    implementation(libs.update.versions.gradle.plugin)
    implementation(libs.ksp.gradle.plugin)
    implementation(libs.detekt.gradle.plugin)
}

// https://docs.gradle.org/current/userguide/preparing_to_publish.html
gradlePlugin {
    website = providers.gradleProperty("POM_URL").get()
    vcsUrl = providers.gradleProperty("POM_URL").get()

    plugins {
        // Core
        register("androidApplication") {
            id = "com.yugyd.buildlogic.android.application"
            implementationClass =
                "com.yugyd.buildlogic.convention.android.AndroidApplicationPlugin"
            displayName = "Android application convention plugin"
            description =
                "Set sdk versions, config compileOptions, config kotlin"
            tags.set(listOf("android", "application", "convention"))
        }
        register("androidLibrary") {
            id = "com.yugyd.buildlogic.android.library"
            implementationClass =
                "com.yugyd.buildlogic.convention.android.AndroidLibraryPlugin"
            displayName = "Android library convention plugin"
            description =
                "Set sdk versions, config compileOptions, config kotlin and disable unnecessary android tests"
            tags.set(listOf("android", "application", "convention"))
        }
        register("kotlinJvm") {
            id = "com.yugyd.buildlogic.kotlin.jvm"
            implementationClass =
                "com.yugyd.buildlogic.convention.kotlin.KotlinJvmPlugin"
            displayName = "Kotlin JVM convention plugin"
            description = "Set java version to 11"
            tags.set(listOf("kotlin", "jvm", "convention", "config"))
        }

        // Build type
        register("buildTypeAndroidApplication") {
            id = "com.yugyd.buildlogic.application.buildtype"
            implementationClass =
                "com.yugyd.buildlogic.convention.buildtype.BuildTypeAndroidApplicationPlugin"
            displayName = "Build type android application convention plugin"
            description = "Set build types and disable unused product flavor variants"
            tags.set(listOf("android", "application", "convention", "build-type"))
        }
        register("buildTypeAndroidLibrary") {
            id = "com.yugyd.buildlogic.library.buildtype"
            implementationClass =
                "com.yugyd.buildlogic.convention.buildtype.BuildTypeAndroidLibraryPlugin"
            displayName = "Build type android library convention plugin"
            description = "Set build types and disable unused product flavor variants"
            tags.set(listOf("android", "library", "convention", "build-type"))
        }

        // Compose
        register("composeAndroidApplication") {
            id = "com.yugyd.buildlogic.application.compose"
            implementationClass =
                "com.yugyd.buildlogic.convention.compose.ComposeAndroidApplicationPlugin"
            displayName = "Compose android application convention plugin"
            description =
                "Add compose compiler metrics, set compiler version, add bom and preview dependencies"
            tags.set(listOf("android", "application", "convention", "compose"))
        }
        register("composeAndroidLibrary") {
            id = "com.yugyd.buildlogic.library.compose"
            implementationClass =
                "com.yugyd.buildlogic.convention.compose.ComposeAndroidLibraryPlugin"
            displayName = "Compose android library convention plugin"
            description =
                "Add compose compiler metrics, set compiler version, add bom and preview dependencies"
            tags.set(listOf("android", "library", "convention", "compose"))
        }

        // Jacoco
        register("jacocoAndroidApplication") {
            id = "com.yugyd.buildlogic.application.jacoco"
            implementationClass =
                "com.yugyd.buildlogic.convention.jacoco.JacocoAndroidApplicationPlugin"
            displayName = "Jacoco android application convention plugin"
            description = "Set toolVersion, add jacoco test report task and config excludes and etc"
            tags.set(listOf("android", "application", "convention", "jacoco"))
        }
        register("jacocoAndroidLibrary") {
            id = "com.yugyd.buildlogic.library.jacoco"
            implementationClass =
                "com.yugyd.buildlogic.convention.jacoco.JacocoAndroidLibraryPlugin"
            displayName = "Jacoco android library convention plugin"
            description = "Set toolVersion, add jacoco test report task and config excludes and etc"
            tags.set(listOf("android", "library", "convention", "jacoco"))
        }
        register("jacocoKotlinJvm") {
            id = "com.yugyd.buildlogic.kotlin.jacoco"
            implementationClass =
                "com.yugyd.buildlogic.convention.jacoco.JacocoKotlinJvmPlugin"
            displayName = "Jacoco kotlin JVM convention plugin"
            description = "Set toolVersion, add jacoco test report task and config excludes and etc"
            tags.set(listOf("kotlin", "jvm", "convention", "jacoco"))
        }

        // Lint
        register("lintAndroidApplication") {
            id = "com.yugyd.buildlogic.application.lint"
            implementationClass =
                "com.yugyd.buildlogic.convention.lint.LintAndroidApplicationPlugin"
            displayName = "Lint android application convention plugin"
            description =
                "Set disables, enable abortOnError, disable checkReleaseBuilds, enable ignoreTestSources and warningsAsErrors"
            tags.set(listOf("android", "application", "convention", "lint"))
        }
        register("lintAndroidLibrary") {
            id = "com.yugyd.buildlogic.library.lint"
            implementationClass =
                "com.yugyd.buildlogic.convention.lint.LintAndroidLibraryPlugin"
            displayName = "Lint android library convention plugin"
            description =
                "Set disables, enable abortOnError, disable checkReleaseBuilds, enable ignoreTestSources and warningsAsErrors"
            tags.set(listOf("android", "library", "convention", "lint"))
        }
        register("lintKotlinJvm") {
            id = "com.yugyd.buildlogic.kotlin.lint"
            implementationClass =
                "com.yugyd.buildlogic.convention.lint.LintJvmKotlinPlugin"
            displayName = "Lint kotlin JVM convention plugin"
            description =
                "Set disables, enable abortOnError, disable checkReleaseBuilds, enable ignoreTestSources and warningsAsErrors"
            tags.set(listOf("kotlin", "jvm", "convention", "lint"))
        }

        // Publish
        register("publishAndroidLibrary") {
            id = "com.yugyd.buildlogic.library.publish"
            implementationClass =
                "com.yugyd.buildlogic.convention.publish.PublishAndroidLibraryPlugin"
            displayName = "Publish android library convention plugin"
            description = " Add maven repositories and publications config"
            tags.set(listOf("android", "library", "convention", "publish"))
        }
        register("publishKotlinJvm") {
            id = "com.yugyd.buildlogic.kotlin.publish"
            implementationClass =
                "com.yugyd.buildlogic.convention.publish.PublishKotlinJvmPlugin"
            displayName = "Publish kotlin JVM convention plugin"
            description = " Add maven repositories and publications config"
            tags.set(listOf("kotlin", "jvm", "convention", "publish"))
        }
        register("publishPlatform") {
            id = "com.yugyd.buildlogic.platform.publish"
            implementationClass =
                "com.yugyd.buildlogic.convention.publish.PublishPlatformPlugin"
            displayName = "Publish java platform convention plugin"
            description = " Add maven repositories and publications config"
            tags.set(listOf("java-platform", "convention", "publish"))
        }

        // Test
        register("testAndroidApplication") {
            id = "com.yugyd.buildlogic.application.test"
            implementationClass =
                "com.yugyd.buildlogic.convention.test.TestAndroidApplicationPlugin"
            displayName = "Test android application convention plugin"
            description = "Add test instrumentation runner and set test options"
            tags.set(listOf("android", "application", "convention", "test"))
        }
        register("testAndroidLibrary") {
            id = "com.yugyd.buildlogic.library.test"
            implementationClass =
                "com.yugyd.buildlogic.convention.test.TestAndroidLibraryPlugin"
            displayName = "Test android library convention plugin"
            description = "Add test instrumentation runner and set test options"
            tags.set(listOf("android", "library", "convention", "test"))
        }

        // Tools
        register("dependencyUpdates") {
            id = "com.yugyd.buildlogic.dependency.updates"
            implementationClass = "com.yugyd.buildlogic.convention.tools.DependencyUpdatesPlugin"
            displayName = "Dependency updates plugin"
            description = "Config dependency updates plugin"
            tags.set(listOf("dependency-updates", "version-check", "tool"))
        }
        register("hiltAndroid") {
            id = "com.yugyd.buildlogic.hilt"
            implementationClass = "com.yugyd.buildlogic.convention.tools.HiltAndroidPlugin"
            displayName = "Hilt plugin"
            description = "Add hilt plugin, library and ksp compiler"
            tags.set(listOf("di", "hilt", "tool"))
        }

        // Other
        register("buildTypeApkVersion") {
            id = "com.yugyd.buildlogic.buildtype.apk.version"
            implementationClass =
                "com.yugyd.buildlogic.convention.versionapk.BuildTypeApkVersionPlugin"
            displayName = "Debug version application convention plugin"
            description = "Add static version values in debug application"
            tags.set(listOf("android", "application", "convention", "apk-version"))
        }
        register("detektPlugin") {
            id = "com.yugyd.buildlogic.detekt"
            implementationClass = "com.yugyd.buildlogic.convention.detekt.DetektPlugin"
            displayName = "Detekt convention plugin"
            description = "Configure detekt for static code analysis"
            tags.set(listOf("static-analysis", "convention", "detekt"))
        }
    }
}

signing {
    useInMemoryPgpKeys(
        System.getenv("SIGNING_KEY_ID"),
        System.getenv("SIGNING_KEY"),
        System.getenv("SIGNING_PASSWORD")
    )
    sign(publishing.publications)
}
