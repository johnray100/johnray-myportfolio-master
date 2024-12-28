# Step 1: Gumamit ng official Java image na base
FROM openjdk:23-jdk-slim

# Step 2: I-set ang working directory sa container
WORKDIR /app

# Step 3: I-copy ang jar file ng Spring Boot app sa container
COPY target/johnray-myportfolio-master-0.0.1-SNAPSHOT.jar /app/my-portfolio.jar

# Step 4: I-expose ang port na ginagamit ng iyong app (default Spring Boot port: 8080)
EXPOSE 8080

# Step 5: I-run ang Spring Boot app
ENTRYPOINT ["java", "-jar", "/app/my-portfolio.jar"]
