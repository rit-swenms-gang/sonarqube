# System Testing

## Overview

To test the system of SonarQube, we first need an application to analyze. The `dummy-project`
directory is a modified version of a JUnit example project for Gradle. Jacoco was added for coverage
support.

## How to Run

Navigate to the `dummy-project` directory

```console
cd courseProjectCode/dummy-project
```

Follow the steps in the [SonarQube Setup Instructions](../Setup/README.md#sonarqube-analysis)
to set up a local SonarQube server.
Use the name `dummy-project` for the project name/key and `master` for the main branch.

Run the tests and upload the results to SonarQube

```console
./gradlew clean build test sonar \
  -Dsonar.token=<YOUR_SONARQUBE_TOKEN>
```

Replace `<YOUR_SONARQUBE_TOKEN>` with the token generated in the setup instructions.

View the results in your local SonarQube instance at [http://localhost:9000/](http://localhost:9000/).
