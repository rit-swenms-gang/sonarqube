# Mutation Testing Report

## Overview

Prior to this report, mutation testing had not been set up for this project. We have now
implemented mutation testing using [PIT][pit], a mutation testing tool for Java.

The tool is configured to run with Gradle, and creates reports in the `build/reports/pitest` directory
of each nested directory with a `build.gradle` file.

[pit]: https://pitest.org

## Initial Mutation Testing Results

After running the initial mutation tests using PIT, we obtained quite a few results over
the multi-module project.
The tests took multiple hours to run, so for brevity only some samples are shown below:

| sonar-application          | Value          |
|----------------------------|----------------|
| Total Mutants              | 16             |
| Killed Mutants             | 0              |
| Surviving Mutants          | 16             |
| Mutation Coverage (%)      | 0              |

| sonar-core                 | Value          |
|----------------------------|----------------|
| Total Mutants              | 1499           |
| Killed Mutants             | 1046           |
| Surviving Mutants          | 453            |
| Mutation Coverage (%)      | 70             |

| sonar-duplication          | Value          |
|----------------------------|----------------|
| Total Mutants              | 799            |
| Killed Mutants             | 659            |
| Surviving Mutants          | 140            |
| Mutation Coverage (%)      | 82             |

| sonar-markdown             | Value          |
|----------------------------|----------------|
| Total Mutants              | 68             |
| Killed Mutants             | 56             |
| Surviving Mutants          | 12             |
| Mutation Coverage (%)      | 82             |

| sonar-plugin-api-impl      | Value          |
|----------------------------|----------------|
| Total Mutants              | 1556           |
| Killed Mutants             | 1103           |
| Surviving Mutants          | 453            |
| Mutation Coverage (%)      | 71             |

| sonar-sarif                | Value          |
|----------------------------|----------------|
| Total Mutants              | 4748           |
| Killed Mutants             | 0              |
| Surviving Mutants          | 4748           |
| Mutation Coverage (%)      | 0              |

| sonar-scanner-engine       | Value          |
|----------------------------|----------------|
| Total Mutants              | 3719           |
| Killed Mutants             | 2446           |
| Surviving Mutants          | 1273           |
| Mutation Coverage (%)      | 66             |

| sonar-scanner-protocol     | Value          |
|----------------------------|----------------|
| Total Mutants              | 10874          |
| Killed Mutants             | 771            |
| Surviving Mutants          | 9376           |
| Mutation Coverage (%)      | 7              |

| sonar-shutdowner           | Value          |
|----------------------------|----------------|
| Total Mutants              | 9              |
| Killed Mutants             | 5              |
| Surviving Mutants          | 4              |
| Mutation Coverage (%)      | 56             |

| sonar-testing-harness      | Value          |
|----------------------------|----------------|
| Total Mutants              | 237            |
| Killed Mutants             | 115            |
| Surviving Mutants          | 122            |
| Mutation Coverage (%)      | 49             |

| sonar-testing-ldap         | Value          |
|----------------------------|----------------|
| Total Mutants              | 58             |
| Killed Mutants             | 26             |
| Surviving Mutants          | 32             |
| Mutation Coverage (%)      | 46             |

| sonar-ws                   | Value          |
|----------------------------|----------------|
| Total Mutants              | 103220         |
| Killed Mutants             | 199            |
| Surviving Mutants          | 103021         |
| Mutation Coverage (%)      | 0              |

| sonar-ws-generator         | Value          |
|----------------------------|----------------|
| Total Mutants              | 71             |
| Killed Mutants             | 0              |
| Surviving Mutants          | 71             |
| Mutation Coverage (%)      | 0              |

## Added Tests

To resolve some of the surviving mutants, we added the following tests:

| Test File | Description | Impact |
|-----------|-------------|--------|
| DefaultUserTest.java | Added tests for the DefaultUser class | Increased coverage from 0% to 100%, killed all 18 mutants |

## Final Mutation Testing Results

After adding the tests, we ran the mutation tests again and obtained the following results:

| sonar-core                 | Value          |
|----------------------------|----------------|
| Total Mutants              | 1499           |
| Killed Mutants             | 1060           |
| Surviving Mutants          | 439            |
| Mutation Coverage (%)      | 71             |

## Group Contributions

| Member | Task/Contribution | Notes |
|--------|-------------------|-------|
| Andrew | Create README and report | Initial write-up of mutation testing setup and results |
|        | Create tests for DefaultUser class | Added JUnit tests to cover DefaultUser functionality and mutations |
| Christian | Set up PIT configuration | Configured PIT settings in gradle build file |
