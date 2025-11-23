# Security Testing

## Overview

## How to Run

Navigate to the `dummy-project` directory

```console
cd courseProjectCode/system-testing/dummy-project
```

Follow the steps in the [SonarQube Setup Instructions](../Setup/README.md#sonarqube-analysis)
to set up a local SonarQube server.

Run the tests and upload the results to SonarQube

```console
./gradlew clean build test sonar \
  -Dsonar.token=<YOUR_SONARQUBE_TOKEN>
```

Replace `<YOUR_SONARQUBE_TOKEN>` with the token generated in the setup instructions.

View the results in your local SonarQube instance at [http://localhost:9000/](http://localhost:9000/).
