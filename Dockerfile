FROM java:8
 
ADD target/feedback-1.0.0-SNAPSHOT.jar /feedback.jar
 
EXPOSE 8080
 
CMD java -jar /feedback.jar
