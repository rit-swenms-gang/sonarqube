# Mutation Testing

## Overview

Mutation testing for this project is implemented with [PIT][pit],
a popular mutation testing tool for Java.

[pit]: https://pitest.org

## How to Run

To run mutation testing with PIT, use the following Gradle command:

```console
./gradlew pitest
```

This command will execute the mutation tests and generate reports at [`build/reports/pitest`][build-loc]
for each nested project.

[build-loc]: ../../sonar-core/build/reports/pitest/index.html
