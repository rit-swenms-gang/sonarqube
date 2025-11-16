# System Testing

## Overview

To test the system of SonarQube, we first need an application to analyze. The `dummy-project`
directory is a modified version of a JUnit example project for Gradle. Jacoco was added for coverage
support.

## How to Run

<details>
  <summary>`dummy-project`</summary>

```bash
cd courseProjectCode/system-testing/dummy-project
./gradlew clean test
```
</details>
