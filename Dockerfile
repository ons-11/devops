FROM openjdk:11
COPY target/achat.jar achat.jar
ENTRYPOINT ["java", "-jar", "/achat.jar"]