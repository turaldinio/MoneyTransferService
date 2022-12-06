FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 5500

COPY target/MoneyTransferService-0.0.1-SNAPSHOT.jar moneyApp.jar

CMD ["java", "-jar", "moneyApp.jar" ]

