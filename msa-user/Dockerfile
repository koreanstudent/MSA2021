FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE=build/libs/msa-user.jar
COPY ${JAR_FILE} user.jar

ENTRYPOINT ["java","-jar","/user.jar"]