FROM amazoncorretto:11-alpine
LABEL maintainer="The M.E.R.I.T Team"
WORKDIR network-graph
COPY ./target/network-ui-0.0.1.jar network-ui.jar
RUN apk upgrade --update-cache --available && \
    rm -rf /var/cache/apk/*
EXPOSE 4200
ENTRYPOINT ["java","-jar","network-ui.jar"]