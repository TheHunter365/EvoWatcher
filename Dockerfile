# Build stage

FROM maven:3.5.2-jdk-8 AS build

MAINTAINER TheHunter365

RUN mkdir -p /usr/src/evowatcher

WORKDIR /usr/src/app
ADD . /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

# Deploy stage

FROM openjdk:8
COPY --from=build /usr/src/app/config.json /usr/app/config.json
COPY --from=build /usr/src/app/EvoWatcherController/target/EvoWatcherController-1.0-SNAPSHOT.jar /usr/app/EvoWatcherController-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/app/EvoWatcherController-1.0-SNAPSHOT.jar"]
