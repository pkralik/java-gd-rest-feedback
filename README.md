## About

Java Maven project with a RESTful Feedback API in Spring Boot.

## Runnning this project

```
mvn spring-boot:run
```

## Building the project

```
mvn clean package && java -jar target/feedback-1.0.0-SNAPSHOT.jar
```

## Running tests

```
mvn clean verify

```

## Example commands

Listing of all feedbacks:
```
curl http://localhost:8080/feedback
```

Listing of feedbacks for a person name1:
```
curl http://localhost:8080/feedback/name1
```

Creating a new feedback:
```
curl -i -X POST http://localhost:8080/feedback -H "Content-Type:application/json" -d '{  "name" : "frodo",  "summary" : "Baggins" }'
```

Service health:
```
curl http://localhost:8080/health
```

## LICENSE

The code is released under the BSD 3-Clause License. See LICENSE for details.
