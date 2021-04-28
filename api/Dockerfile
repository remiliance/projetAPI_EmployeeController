FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
EXPOSE 9000
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
