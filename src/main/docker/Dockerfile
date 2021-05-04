FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade

VOLUME /tmp

ENV SERVER_PORT 8080
ENV APP_STORE /app-store

ARG MAIN_CLASS
ARG PROGRAM_NAME

ENV MAIN_CLASS ${MAIN_CLASS}
ENV PROGRAM_NAME ${PROGRAM_NAME}

EXPOSE 8080

RUN mkdir -p /usr/local/dockerize

ADD @project.build.finalName@.jar '/usr/local/dockerize/'

ADD run.sh run.sh

RUN chmod +x run.sh

CMD ./run.sh