FROM java:8
LABEL maintainer="mhcl@msn.com"
WORKDIR /app
COPY target/spotapi-0.0.1-SNAPSHOT.jar /app/spotapi.jar
ENTRYPOINT ["java","-jar","spotapi.jar"]