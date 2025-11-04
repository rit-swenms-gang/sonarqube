# Static Analysis Report

We (unsurprisingly) have been using an instance of SonarQube Server in a Docker container to
continually monitor the quality of changes that we have made to the tests in the SonarQube source
repository. As a result, we've largely been able to focus on our introduced issues, although there
are quite a few existing issues from the SonarQube repository itself. However, with a multi-module
project of this scale, it does not seem surprising that there would be a large rate of issues
tracked, especially when accounting for (what appears to be) an internal migration from JUnit4 to
JUnit 5.

## Initial Analysis Report

As mentioned in previous reports, the build pipeline can be summarized in the following command:

```console
# MacOS
./gradlew clean build test jacocoTestReport sonar # optional sonar properties as CLI args
```

We use `clean`, `build`, and `test` to safely build and execute the test suites in the project. The
`jacocoTestReport` step generates the coverage files to be parsed by the `sonar` command, which
feeds the results to the containerized server for analysis. Results are stored in a PostgreSQL
container for continuous issue tracking.

The results of our [most recent assignment](../Mutation-Testing/)'s commit can be seen below.

![Initial SonarQube static analysis report. Key point: 8 introduced issues](./Initial-report.png)

## Changes and Final Report

It turns out that we made a mistake in our assertion statement ordering, putting the actual output
value before the expected value. Convention dictates that this should be reversed.

![Sample SonarQubeIssue for Intentionality](./Sample-issue.png)

This required only a simple update in the test file.

One of the pre-existing issues found was in a UUID utility class, where a deprecated method
`createFast` was being used. This method has been deprecated in favor of the `create` method, which
is now the preferred way to generate UUIDs. We updated all references to this method in the
project to use the `create` method instead.

The results of this new commits are as follows:

![Final SonarQube static analysis report. Key point: 0 issues](./Final-report.png)

## Group Contributions

| Member | Task/Contribution | Notes |
|--------|-------------------|-------|
| Andrew | Implement changes to UUID util | Remove deprecated `createFast` method and replace references with `create` method |
| Christian | Analyze report findings and implement | Reviewed SonarQube report and wrote suggested changes |
