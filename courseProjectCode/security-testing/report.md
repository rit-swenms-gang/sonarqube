# System Testing Report

## Test Scope and Coverage

Sonar Qube is able to use rule sets to detect software vulnerabilites during its analysis processes.
As mentioned in previous iterations, these detections are a part of a continuous improvement
philosophy. Sonar Qube is able to analyze the commit history to determine when vulnerabilities are
introduced during its static analysis.

In the attempts for setting up system tests, it was required to create credentials for the Sonar
Qube instance to initialize projects and users. The introduced vulnerabilties come from the default
Java rule set and were detected upon the last merge into the `master` branch. Some of the rules come
from OWASP Top 10 2021, OWASP Mobile Top 10 2024, and CWE.

## Vulnerability Summary

| Sonar Qube Rule | Associated Software Vulnerability IDs | Description | Number Found |
|-|-|-|-|
| `S6418` | `CVE-2022-25510` `CVE-2021-42635` | Hard-coded secrets are security-sensitive | 1 |
| `S2068` | `CVE-2019-13466` `CVE-2018-15389` | Hard-coded passwords are security-sensitive | 5 |
| `S2077` | - | Formatting SQL queries is security-sensitive | 3 |
| `S5332` | - | Using clear-text protocols is security-sensitive | 1 |
| `S4507` | - | Make sure this debug feature is deactivated before delivering the code in production | 1 |
| `S5443` | - | Make sure publicly writable directories are used safely here. | 1 |
| `S4790` | - | Make sure this weak hash algorithm is not used in a sensitive context here | 10 |
| `S4036` | - | Make sure the "PATH" variable only contains fixed, unwriteable directories | 1 |

## Execution and Results

For our use case of testing, the hard coded passwords pose no significant threat to the security of
SonarQube's main application since all created instances are purely hypothetical. We could
theoretically improve security by moving these details to environment variables, but this would
greatly increase complexity for largely minimal impact. We have decided to acknowledge the issue,
but for the sake of progress simply track the problems.

SQL injection warnings came from Sonar Qube's use of prepared statements and parameterized queries.
While the analysis seems fair that these are difficult to maintain, their benefit seems crucial to
the functionality of the PostgreSQL database.

The remaining issues came from lower risk items pertaining to the use of `HTTP` over `HTTPS` (S5332),
printing a stack trace in a JSON logger in production level code (S4507), making sure directories
are writable (S5443), ensuring that an insecure hashing algorithm was not being used for security
purposes (S4790), and that `PATH` was fixed and unwritable directory (S4036).

## Group Contributions

| Member | Task/Contribution | Notes |
|--------|-------------------|-------|
| Andrew | | |
| Christian |  |  |
