FROM openjdk:8 AS build

ADD . /app

WORKDIR /app

RUN ./mvnw clean package -Dmaven.test.skip=true

FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

COPY --from=build /app/target/gesplan-compra22-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

ENTRYPOINT [ "java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar", "/app/gesplan-compra22-0.0.1-SNAPSHOT.jar" ]
