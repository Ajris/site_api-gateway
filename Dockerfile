FROM gradle:jdk12 as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:12-jdk-oracle
EXPOSE 8081
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/site_api-gateway.jar
ENTRYPOINT ["java", "-jar", "/app/site_api-gateway.jar"]