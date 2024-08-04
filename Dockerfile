# Use an official OpenJDK 22 runtime as a parent image
FROM openjdk:22-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/demoHazelcast-0.0.1-SNAPSHOT.jar /app/demoHazelcast.jar

# Expose the ports needed for the application and Hazelcast
EXPOSE 8080 5701

# Run the JAR file
ENTRYPOINT ["java","-jar","/app/demoHazelcast.jar"]
