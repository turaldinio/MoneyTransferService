FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 5500

COPY target/MoneyTransferService-0.0.1-SNAPSHOT.jar backendApp.jar

CMD ["java", "-jar", "/backendApp.jar" ]

