# Welcome to World Explorer Application

### Requirements

The project requires Java 11 and makes use of Maven and runs with H2 in-memory database

### Run the application using maven

Run the application from terminal:

```console
$ mvn spring-boot:run
```

### H2 database

Schema and data both are created using schema.sql and data.sql.
Console is available on http://localhost:8080/h2-console/login.jsp

### Output
Data is stored in hierarchical format in a tree and result of this application is as below

```text
City1 : Country1 : Continent1
City2 : Country2 : Continent2
.
.
.
```







