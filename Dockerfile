# How to Use Docker File for Deployment
# It creates an image combining corretto as runtime with the JAR file
#FROM amazoncorretto:17
FROM openjdk:22-jdk
ADD target/jobsapi-app.jar /tmp/jobsapi-app.jar
ENTRYPOINT ["java", "-jar" , "/tmp/jobsapi-app.jar"]