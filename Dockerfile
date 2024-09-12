#
# Build stage
#
FROM maven:3.8.7-eclipse-temurin-19 AS build
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM openjdk:19-jdk-slim
COPY --from=build /target/asklepios-server-0.0.1-SNAPSHOT.jar asklepios-server.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","asklepios-server.jar"]