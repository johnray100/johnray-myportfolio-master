
# Use JDK 23 runtime as the base image
FROM eclipse-temurin:23-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/johnray-myportfolio-master.jar /app/myportfolio.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "myportfolio.jar"]


