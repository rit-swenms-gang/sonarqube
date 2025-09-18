# Test Report

Due to the size of the generated reports, code coverage metrics can be reviewed in the
[metrics README][report_path].

[report_path]: ../Metrics/jacocoAggregateReport/html/index.html

## Running the Tests

1. Clone the `sonarqube` fork repo with `git clone`.
2. As shown in the root `README`, run the `./gradlew jacocoAggregateReport` command.
3. Reports are generated under the `./build/reports/jacoco/jacocoAggregateReport/` directory.
   View results in a browser from `./build/reports/jacoco/jacocoAggregateReport/html/index.html`.
