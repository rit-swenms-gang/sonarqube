# Integration Testing

## Overview

For integration testing, we use the existing testing framework set up in the SonarQube project,
which is primarily based on JUnit. Any mocked components are created using Mockito.

## How to Run

As with running unit tests, integration tests can be executed using Gradle:

```console
./gradlew clean build test jacocoTestReport sonarqube
```
