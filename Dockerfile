FROM gradle:7.6-jdk17-alpine as build

ENV APP_HOME=/apps

WORKDIR $APP_HOME

# Windows 경로 대신 상대 경로 또는 Linux 스타일 경로 사용
COPY build.gradle settings.gradle gradlew $APP_HOME/
COPY gradle $APP_HOME/gradle/

RUN chmod +x gradlew

RUN ./gradlew build || return 0

# 경로 수정
COPY src $APP_HOME/src
RUN ./gradlew clean build

FROM openjdk:17.0.2-jdk

ENV APP_HOME=/apps
ARG ARTIFACT_NAME=app.jar
ARG JAR_FILE_PATH=build/libs/jobadream-0.0.1-SNAPSHOT.jar

WORKDIR $APP_HOME

# Linux 스타일 경로 사용
COPY --from=build $APP_HOME/$JAR_FILE_PATH $ARTIFACT_NAME

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
