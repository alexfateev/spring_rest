FROM khipu/openjdk17-alpine
EXPOSE 8080
#ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]