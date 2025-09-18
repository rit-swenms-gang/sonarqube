# Environment Setup

## Test Suite Summary

As previously discovered, SonarQube uses Gradle, JUnit, and Mockito for their unit and integration
tests. Jacoco is used to generate reports into the build directory for each subsystem. SonarQube
relies on JDK 17 and works best Gradle 7. The authors have been working with Java 22 and Gradle 9,
but were able to install Gradle 7 and run the existing test suite. The `jacocoAggregateReport` Gradle
plugin was added to the `build.gradle` file to compile a comprehensive coverage report.

## Baseline Coverage Metrics

* The Jacoco report captured a total 295,170 lines (statements). 135,616 were missed, resulting in
  45.95% statement coverage.
* Out of 106,641 if/switch statements (branches), 67,352 were missed, resulting in about 36%
  branch coverage.

*Note: the values above are derived from the Jacoco coverage report, which provides details on
various aspects of the test suite, including coverage, cyclomatic complexity, and more. The
definition of each column of the report can be found int the [Jacoco documentation][jacoco_docs].

[jacoco_docs]: (https://www.eclemma.org/jacoco/trunk/doc/counters.html)
