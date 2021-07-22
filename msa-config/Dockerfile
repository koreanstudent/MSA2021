FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE=build/libs/msa-config.jar
COPY ${JAR_FILE} config.jar

ENTRYPOINT ["java","-jar","/config.jar"]