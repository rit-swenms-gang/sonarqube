# Integration Testing

## Overview

For integration testing, we use the existing testing framework set up in the SonarQube project,
which is primarily based on JUnit. Any mocked components are created using Mockito.

## How to Run

As with running unit tests, integration tests can be executed using Gradle:

```console
./gradlew build test
```

The results of the tests will be displayed in the console output, and detailed reports can be found
in the `build/reports/tests/test` directory of each submodule.
