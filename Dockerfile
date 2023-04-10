FROM amazoncorretto:17.0.6-alpine3.17
MAINTAINER daianadasilva
WORKDIR /app
COPY target/solicitantes-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]