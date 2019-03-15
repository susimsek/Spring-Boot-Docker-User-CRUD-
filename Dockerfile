#pull base image
FROM openjdk:8-jdk-alpine

#maintainer 
MAINTAINER suaybsimsek58@gmail.com


ARG PACKAGED_JAR=target/rest-0.0.1-SNAPSHOT.jar

ADD ${PACKAGED_JAR} mcy-sb-devtools-docker.jar

ENTRYPOINT ["java","-jar","-Xdebug","-Xrunjdwp:server=y,transport=dt_socket,address=8001,suspend=n","/mcy-sb-devtools-docker.jar"]

EXPOSE 8080:8080
EXPOSE 8001:8001
