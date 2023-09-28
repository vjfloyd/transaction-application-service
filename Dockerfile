# Stage 1: Build the Java application with Maven
FROM maven:3.8.4 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

# Stage 2: Create the runtime image with Java 17
FROM openjdk:17-jdk-slim

# Set environment variables, if needed
# ENV APP_ENV=production
WORKDIR /app

COPY --from=build /app/target/transactions-application-service-0.0.1.jar ./app.jar
CMD ["java", "-jar", "app.jar"]
