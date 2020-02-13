# build step
FROM adoptopenjdk:11-jre-openj9 AS build

WORKDIR /urs/src/app

COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .

RUN sh ./mvnw dependency:go-offline

COPY src/ src/

RUN sh ./mvnw package

# serve step
FROM adoptopenjdk:11-jre-openj9 AS serve

ARG JAR_FILE=target/*.jar

EXPOSE 8080

WORKDIR /opt/app

COPY --from=build /urs/src/app/${JAR_FILE} app.jar

ENTRYPOINT java \
           -Djava.security.egd=file:/dev/./urandom \
           -jar \
           app.jar
