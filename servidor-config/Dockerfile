FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
#Runtime
FROM ecliupse-temurin:25-jdk
WORKDIR /app
ARG SERVICE_NAME
COPY --from=builder /app/${SERVICE_NAME}target/${SERVICE_NAME}-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080 8083 8084 8085 8761 8888 9009
ENTRYPOINT ["java","-jar","app.jar"]