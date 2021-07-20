FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE=build/libs/msa-gateway.jar
COPY ${JAR_FILE} gateway.jar

ENTRYPOINT ["java","-jar","/gateway.jar"]