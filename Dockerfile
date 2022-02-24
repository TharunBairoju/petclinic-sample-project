FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/petclinic.jar
COPY ${JAR_FILE} petclinic.jar
ENTRYPOINT ["java","-jar","/petclinic.jar"]