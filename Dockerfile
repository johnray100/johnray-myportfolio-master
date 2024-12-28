# Use a compatible JDK base image
FROM eclipse-temurin:23-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/johnray-myportfolio-master-*.jar /app/myportfolio.jar

# Expose the port your application uses
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "myportfolio.jar"]
