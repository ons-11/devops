FROM openjdk:8-jdk-alpine
COPY /target/achat-1.0.jar tpachat-1.0.jar
ENTRYPOINT ["java","-jar","/tpachat-1.0.jar"]
