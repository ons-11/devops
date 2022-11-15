FROM openjdk:8-jdk-alpine
RUN cp target/achat-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]
