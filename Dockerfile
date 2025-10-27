# Stage 1: Build the application
FROM maven:3.9.3-eclipse-temurin-20 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (cache layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application (package as jar)
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:20-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Environment variables (can be overridden in Docker run or Compose)
ENV SPRING_PROFILES_ACTIVE=prod
ENV DATABASE_URL=jdbc:postgresql://dpg-d3voeuili9vc73cs3jkg-a.oregon-postgres.render.com:5432/falcon_cargo_db
ENV DATABASE_USERNAME=bojucode
ENV DATABASE_PASSWORD=JTHNDQze5lbMcJGgiN3qfKKoAdRb31oC

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
