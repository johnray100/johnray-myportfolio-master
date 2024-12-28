# Use a compatible JDK 23 runtime
FROM bellsoft/liberica-openjdk-debian:23

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/*.jar /app/myportfolio.jar

# Expose the port your Spring Boot application runs on
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "myportfolio.jar"]
