FROM openjdk:11
COPY target/springboot-app.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]