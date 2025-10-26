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

This command will execute the mutation tests and generate a report at [`build/reports/pitest`][build-loc].

[build-loc]: ./build/reports/pitest/index.html
