FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} eureka.jar

ENTRYPOINT ["java","-jar","/eureka.jar"]