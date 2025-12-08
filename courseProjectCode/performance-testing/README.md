# Performance Testing

## Overview

Performance testing for this project is implemented with [JMeter][jmeter-about], an open-source load
testing tool for Java.

## How to Run

If you haven't set up a SonarQube server yet, follow the steps in the
[SonarQube Setup Instructions][sonarqube-setup] to set up and run a local SonarQube server.

Install JMeter if you haven't already. You can download it from [the official Apache JMeter website][jmeter-install].
Note that JMeter requires Java to be installed on your system.
See the [JMeter user manual][jmeter-user-manual] for more details on installation and setup.

Configure the `JMETER_HOME` environment variable to point to your JMeter installation directory.

JMeter can be run directly from the command line using

  ```console
  ${JMETER_HOME}/bin/jmeter
  or
  ${JMETER_HOME}\bin\jmeter.bat (on Windows)
  ```

*It is not necessary to open the JMeter GUI for running the performance
tests, as they are executed via Gradle.
In fact, running load tests through the GUI is not recommended due to potential performance overhead.*

Run the load tests:

```console
./gradlew loadTest -Dsonar.token=<YOUR_SONARQUBE_USER_TOKEN> -Dsonar.projectKey=<YOUR_PROJECT_KEY>
```

Run the stress tests:

```console
./gradlew stressTest -Dsonar.token=<YOUR_SONARQUBE_USER_TOKEN>
```

Optionally, you can run both tests in sequence with:

```console
./gradlew performanceTest -Dsonar.token=<YOUR_SONARQUBE_USER_TOKEN> -Dsonar.projectKey=<YOUR_PROJECT_KEY>
```

Replace `<YOUR_SONARQUBE_USER_TOKEN>` with a SonarQube user token and
`<YOUR_PROJECT_KEY>` with the SonarQube project key for the project you want to test.
The project key is only required for load tests.
The commands above set the token and project key as system properties.
The commands will fail if the token (and project key for load tests) are not provided.

Optionally, you can specify the SonarQube
user token with the `-Psonar.token` parameter (project property)
or by setting the `SONAR_TOKEN` environment variable.
Similarly, the project key can be provided with the `-Psonar.projectKey` parameter (project property),
or by setting the `SONAR_PROJECT_KEY` environment variable.

Once properties are validated, the command uses a JMeter test plan located at
`performance-testing/jmeter/test-plans` to perform the tests.
`sonar-load-test-plan.jmx` is used for load tests,
and `sonar-stress-test-plan.jmx` is used for stress tests.

After the tests complete, a report will be generated in the
`performance-testing/jmeter/results/` directory. Each test run creates a new subdirectory with a
timestamp to uniquely identify it (e.g. `report-2025-12-05-143200`).

[jmeter-about]: https://jmeter.apache.org/
[jmeter-install]: https://jmeter.apache.org/download_jmeter.cgi
[jmeter-user-manual]: https://jmeter.apache.org/usermanual/get-started.html
[sonarqube-setup]: ../Setup/README.md#sonarqube-analysis
