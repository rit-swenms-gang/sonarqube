# Test Report

Due to the size of the generated reports, previously generated code coverage metrics can be reviewed
in previous commits. To get around this overhead, local [SonarQube][sce] and PostgreSQL Docker
containers were used to analyze the base repository.

[sce]: https://www.sonarsource.com/open-source-editions/sonarqube-community-edition/

## Running the Tests

1. Clone the `sonarqube` fork repo with `git clone`.
2. As shown in the root `README`, run the `./gradlew jacocoAggregateReport` command.
3. Reports are generated under the `./build/reports/jacoco/jacocoAggregateReport/` directory.
   View results in a browser from `./build/reports/jacoco/jacocoAggregateReport/html/index.html`.

## SonarQube Analysis

Authors followed [this video][sq_setup] to gather these setup steps.

1. Clone `sonarqube` repo.
2. Ensure Docker is installed (authors used Docker Desktop).
3. Use command `docker pull sonarqube` to get the latest official SonarQube image.
4. Connect to a database. The following example uses a PostgreSQL Docker image:

   ```console
   docker run -d --name sonarqube-db -e POSTGRES_USER=sonar -e POSTGRES_PASSWORD=sonar -e POSTGRES_DB=sonarqube postgres:alpine
   ```

5. Run the SonarQube server and connect it to the database using the following command:

   ```console
   docker run -d --name sonarqube -p 9000:9000 --link sonarqube-db:db -e SONAR_JDBC_URL=jdbc:postgresql://db:5432/sonarqube -e SONAR_JDBC_USERNAME=sonar -e SONAR_JDBC_PASSWORD=sonar sonarqube
   ```

6. Navigate to [the exposed port](http://localhost:9000/) and sign in with default credentials (
   `admin` and `admin`).
7. Set up a local project. Name the project `sonarqube` with a main branch called `master`.
    Use global settings. Analyze the project locally with a `gradle` configuration.
    Copy the generated token for the next step.
8. Navigate to the cloned repo. Create an environment variable `SONAR_TOKEN` that
    holds the value of the generated token.
9. Build the project and run the analysis with the command:

   ```console
   ./gradlew clean build jacocoTestReport sonar
   ```

   Given the sheer size of the repository, this scan might take quite some time.

[sq_setup]: https://www.youtube.com/watch?v=6vdRvz_LnbQ
