# Use an OpenJDK runtime as a parent image
FROM adoptopenjdk/openjdk11:alpine-jre

# Set the working directory to /app
WORKDIR /app

# Copy the packaged application JAR file to the container
COPY target/mandel-java.jar mandel-java.jar

# Expose port 8080 for the application to listen on
EXPOSE 8080

# Set the command to run the application when the container starts
CMD ["java", "-jar", "mandel-java.jar"]
