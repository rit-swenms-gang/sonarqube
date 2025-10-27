# Mutation Testing Report

## Overview

Prior to this report, mutation testing had not been set up for this project. We have now
implemented mutation testing using [PIT][pit], a mutation testing tool for Java.

The tool is configured to run with Gradle, and creates reports in the `build/reports/pitest` directory.

[pit]: https://pitest.org

## Initial Mutation Testing Results

After running the initial mutation tests using PIT, we obtained the following results:

| Metric                     | Value          |
|----------------------------|----------------|
| Total Mutants              | X              |
| Killed Mutants             | Y              |
| Surviving Mutants          | Z              |
| Mutation Coverage (%)      | (Y / X) * 100  |

## Added Tests

To resolve some of the surviving mutants, we added the following tests:

| Test File | Description | Impact |
|-----------|-------------|--------|
| DefaultUserTest.java | Added tests for the DefaultUser class | Increased coverage from 0% to 100%, killed all 18 mutants |

## Final Mutation Testing Results

After adding the tests, we ran the mutation tests again and obtained the following results:

| Metric                     | Value          |
|----------------------------|----------------|
| Total Mutants              | X              |
| Killed Mutants             | Y              |
| Surviving Mutants          | Z              |
| Mutation Coverage (%)      | (Y / X) * 100  |

## Group Contributions

| Member | Task/Contribution | Notes |
|--------|-------------------|-------|
| Andrew | Create README and report | Initial write-up of mutation testing setup and results |
| Christian | Set up PIT configuration | Configured PIT settings in gradle build file |
