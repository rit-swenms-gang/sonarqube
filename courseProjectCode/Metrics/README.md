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

Project uses gradle, JUnit, Mockito, maybe more?.

 `./gradlew test`
 generates report under `sonarqube/sonar-scanner-engine/build/reports/tests/test/index.html`
