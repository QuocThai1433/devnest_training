# Integrating Flyway into a Spring Boot Project

## Prerequisites
Before starting, make sure you have:

- Java 17+ installed
- Maven installed
- A Spring Boot project set up
- A PostgreSQL or MySQL database (adjust configurations accordingly)
- Git installed for version control

## Step 1: Add Flyway Dependency
Modify the `pom.xml` file by adding the Flyway dependency:

```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```

If using PostgreSQL, also add:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```
### Add Flyway Maven Plugin
In the `<build>` section of `pom.xml`, add the Flyway Maven plugin:

```xml
<plugins>
    <plugin>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-maven-plugin</artifactId>
        <configuration>
    	    <url>jdbc:postgresql://localhost:5432/course-management</url>
            <user>postgres</user>
            <password>postgres</password>
            <schemas>public</schemas>
    	</configuration>
    </plugin>
</plugins>
```

## Step 2: Configure Flyway in `application.properties`
Open `src/main/resources/application.properties` and add the database configuration:

### For PostgreSQL:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/course_management
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver

spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
```

### Note:
- `spring.flyway.enabled=true`: Enables Flyway migration.
- `spring.flyway.baseline-on-migrate=true`: Ensures Flyway runs migrations even on an existing database.

## Step 3: Create the Flyway Migration Files
Flyway migration scripts should be placed in:

```
src/main/resources/db/migration/
```

Each migration file follows the naming convention:

```
V{version}__{description}.sql
```

For example, to create tables, you can have:

**V1__create_tables.sql**
```sql
CREATE TABLE TBL_CATEGORY (
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    DESCRIPTION TEXT,
    CREATED_BY VARCHAR(100) NOT NULL,
    CREATED_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UPDATED_BY VARCHAR(100),
    UPDATED_DATE TIMESTAMP
);
```

For multiple tables, you can add them in the same file or create separate files like:

```
V2__create_TBL_COURSE.sql
V3__create_TBL_STUDENT.sql
```

## Step 4: Run Flyway Migration
Run the following command to apply migrations:

```sh
mvn clean flyway:migrate
```

You should see output indicating the migration was successful.

To check Flyway history in PostgreSQL, run:

```sql
SELECT * FROM flyway_schema_history;
```
or

```sh
mvn clean flyway:info
```

## Step 5: Push to GitLab
After integrating Flyway, create a new Git branch (following your team rule):

```sh
git checkout -b develop_feature_flyway_integration
```

Commit and push the changes:

```sh
git add .
git commit -m "Integrated Flyway with Spring Boot"
git push origin develop_feature_flyway_integration
```

Then, create a Merge Request (MR) on GitLab and assign it to your reviewer.
