# ---------- Stage 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean install -DskipTests

# ---------- Stage 2: Run ----------
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/LifeInWeeks-Backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

