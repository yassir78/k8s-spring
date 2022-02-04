FROM openjdk:8-alpine
COPY target/*.jar app.jar
EXPOSE 9095
ENTRYPOINT ["java","-jar","app.jar"]