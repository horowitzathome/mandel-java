# Use a Java 17 base image as a parent image
FROM openjdk:17-jdk-alpine3.14 AS build

ARG VERSION

# Set the working directory to /app
WORKDIR /app

# Copy the Gradle files to the container
COPY build.gradle settings.gradle gradle.properties gradlew ./
COPY gradle/ gradle/

# Download the project dependencies
RUN ./gradlew build --no-daemon

# Copy the project source code to the container
COPY src/ src/

# Build the project
RUN ./gradlew build --no-daemon

# Use an OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine3.14

ARG VERSION

# Set the working directory to /app
WORKDIR /app

# Copy the packaged application JAR file to the container
COPY --from=build /app/build/libs/mandel-java-${VERSION}.jar mandel-java.jar

# Expose port 8080 for the application to listen on
EXPOSE 8080

# Set the command to run the application when the container starts
CMD ["java", "-jar", "mandel-java.jar"]
