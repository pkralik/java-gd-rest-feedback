# java-gd-rest-feedback
Java RESTful Feedback service

Requires JDK 8 to build

## Building JAR package

mvn clean package && java -jar target/feedback-1.0.0-SNAPSHOT.jar

## Running REST Feedback service

mvn spring-boot:run

## Running tests

mvn clean verify

## REST endpoints

### Listing of all feedbacks

curl http://localhost:8080/feedback

### Listing of feedbacks for a person name1

curl http://localhost:8080/feedback/name1

### Creating a new feedback

curl -i -X POST http://localhost:8080/feedback -H "Content-Type:application/json" -d '{  "name" : "frodo",  "summary" : "Baggins" }'

### REST service health

curl http://localhost:8080/health
