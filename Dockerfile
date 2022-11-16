FROM openjdk:8-jdk-alpine
COPY /var/lib/jenkins/workspace/testtestbuild/target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
