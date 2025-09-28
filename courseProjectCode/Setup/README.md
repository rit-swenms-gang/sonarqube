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

1. Clone `sonarqube` repo.
2. Ensure Docker is installed (authors used Docker Desktop).
3. Use command `docker pull sonarqube` to get the latest official SonarQube image.
4. Connect to a database. Authors followed [this video][sq_setup], using the following command:

   ```console
   docker run -d \
   --name sonarqube \
   -p 9000:9000 \
   --link sonarqube-db:db \ 
   -e SONAR_JDBC_URL=jdbc:postgresql://db:5432/sonarqube \
   -e SONAR_JDBC_USERNAME=sonar \
   -e SONAR_JDBC_PASSWORD=sonar sonarqube
   ```

5. Navigate to [the exposed port](http://localhost:9000/) and sign in with default credentials (
   `admin` and `admin`).
6. Set up a local project. Name the project `sonarqube` with a `gradle` configuration. Select all
   local configuration properties. Copy the generated token for the next step.
7. Navigate to the cloned repo and run the following command:

   ```console
   ./gradlew clean build sonar \
   -Dsonar.projectKey=sonarqube \
   -Dsonar.projectName='sonarqube' \
   -Dsonar.host.url=http://localhost:9000 \
   -Dsonar.token=<token>
   ```

   Replace `<token>` with the generated token.

[sq_setup]: https://www.youtube.com/watch?v=6vdRvz_LnbQ
