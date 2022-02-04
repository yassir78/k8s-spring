FROM adoptopenjdk/openjdk11:latest
COPY target/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","app.jar"]