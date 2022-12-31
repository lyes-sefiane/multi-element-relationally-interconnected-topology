FROM amazoncorretto:11-alpine
LABEL maintainer="The M.E.R.I.T Team"
WORKDIR graph-network-command
COPY ./target/graph-network-command-0.0.1.jar graph-network-command.jar
RUN apk upgrade --update-cache --available && \
    rm -rf /var/cache/apk/*
EXPOSE 8080
ENTRYPOINT ["java","-jar","graph-network-command.jar"]