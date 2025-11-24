# Security Testing

## Overview

Security is already a built in part of SonarQube's continuous improvement. Through static analysis,
it is able to identify and track possible vulnerabilities such as SQL injection or accidental
token leaks. Vulnerabilities found have ranked importance and allow developers to quickly resolve
pending issues.

## How to Run

Follow the steps in the [SonarQube Setup Instructions](../Setup/README.md#sonarqube-analysis)
to set up a local SonarQube server.

Run the tests and upload the results to SonarQube

```console
./gradlew clean build test sonar \
  -Dsonar.token=<YOUR_SONARQUBE_TOKEN>
```

Replace `<YOUR_SONARQUBE_TOKEN>` with the token generated in the setup instructions.

View the results in your local SonarQube instance at [http://localhost:9000/](http://localhost:9000/).

Review security vulnerabilities under the `Security Hotspots` tab.
