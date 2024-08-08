FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/crud-productos-1.0.0.jar /app/crud-productos.jar

ENTRYPOINT ["java", "-jar", "my-api.jar"]