FROM openjdk

WORKDIR /app

COPY ./target/event-processing-*.jar /app/event-processing.jar

EXPOSE 80

CMD ["java", "-jar", "event-processing.jar"]
