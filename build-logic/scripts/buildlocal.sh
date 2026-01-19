#!/bin/bash

# Add signing properties SIGNING_KEY_ID, SIGNING_KEY, SIGNING_PASSWORD to environment variables
./gradlew :library:library-android:publishToMavenLocal --console=plain
./gradlew :library:library-jvm:publishToMavenLocal --console=plain
./gradlew :library:library-bom:publishToMavenLocal --console=plain
