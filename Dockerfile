FROM eclipse-temurin:17.0.11_9-jre-jammy

VOLUME /tmp
WORKDIR /app
COPY target/products-apirest-0.0.1-SNAPSHOT.jar  /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]