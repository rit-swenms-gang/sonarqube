# Metrics Gathering

## Maintainability Analysis

Due to the scale of the SonarQube repo, the CLI utility [`cloc`][cloc] was used to parse all files.
The report was gathered in text and markdown, and breaks down blank lines, comment lines, and code
for each individual file. No assumptions have been made on what code was written or generated, nor
have test files been excluded.

### Steps

1. Download `cloc` on your system (author used `homebrew` on MacOS; `brew install cloc`).
2. Open the `sonarqube` repo in terminal or VS Code.
3. In the terminal (or Code's terminal), run `cloc . --by-file` to print a report.
4. To generate a print report, run `cloc . --by-file > courseProjectCode/Metrics/loc-report.txt` for
   text or `cloc . --by-file --md > courseProjectCode/Metrics/loc-report.md` for markdown.

[cloc]: https://github.com/AlDanial/cloc

## Testability Analysis

SonarQube appears to use Gradle, JUnit, and Mockito for their unit and integration tests. Jacoco
seems to be used to generate reports into the build directory for each subsystem. While it is
possible to run the automated build and test processes, the reviewing the results of all tests does
not appear to be a trivial process. For one, the project relies on JDK 17 and at most Gradle 8.
The authors have been working with Java 22 and Gradle 9, which has resulted in the removal of
deprecated features and incompatible test suites. While it is difficult to guage exactly how many
tests there are, the test compilation process took over 15 minutes to run and contained thousands
of test cases. The authors used the Chat GPT and `jacocoAggregateReport` Gradle plugin to modify the
`build.gradle` file to compile a comprehensive coverage report.

### Steps
1. Clone the `sonarqube` fork repo with `git clone`.
1. As shown in the root `README`, run the `./gradlew jacocoAggregateReport` command.
1. Reports are generated under the `./build/reports/jacoco/jacocoAggregateReport/` directory.
   View results in a browser from `./build/reports/jacoco/jacocoAggregateReport/html/index.html`.
