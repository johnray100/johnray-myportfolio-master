# Exported from Render on 2024-12-27T05:36:08Z
services:
  - type: web
    name: johnray-myportfolio-master
    runtime: docker
    repo: https://github.com/johnray100/johnray-myportfolio-master
    plan: free
    region: singapore
    dockerContext: .
    dockerfilePath: ./Dockerfile
    domains:
      - johnray100.com
      - www.johnray100.com
    previews:
      generation: automatic
version: "1"

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
