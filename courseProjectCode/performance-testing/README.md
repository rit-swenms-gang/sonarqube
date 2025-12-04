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
tests, as they are executed via Gradle.*

Run the performance tests with the command

```console
./gradlew perfTest -Dsonar.token=<YOUR_SONARQUBE_PROJECT_TOKEN>
```

Replace `<YOUR_SONARQUBE_PROJECT_TOKEN>` with the token for your SonarQube project.
The command above sets the token as a system property. Alternatively, you can specify the SonarQube
project token with the `-Psonar.token` parameter (project property)
or by setting the `SONAR_TOKEN` environment variable.

This command uses the JMeter test plan located at
`performance-testing/jmeter/sonar-perf-test.jmx` to perform the tests.

After the tests complete, a report will be generated in the
`performance-testing/jmeter/results/` directory. Each test run creates a new subdirectory with a
timestamp to uniquely identify it (e.g. `report-2025-12-05-143200`).

[jmeter-about]: https://jmeter.apache.org/
[jmeter-install]: https://jmeter.apache.org/download_jmeter.cgi
[jmeter-user-manual]: https://jmeter.apache.org/usermanual/get-started.html
[sonarqube-setup]: ../Setup/README.md#sonarqube-analysis
