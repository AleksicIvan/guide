FROM openjdk:8-alpine

COPY target/uberjar/guide-me-v2.jar /guide-me-v2/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/guide-me-v2/app.jar"]
