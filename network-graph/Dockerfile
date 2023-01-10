FROM amazoncorretto:11-alpine
LABEL maintainer="The M.E.R.I.T Team"
WORKDIR network-graph
COPY ./target/network-graph-0.0.1.jar network-graph.jar
RUN apk upgrade --update-cache --available && \
    rm -rf /var/cache/apk/*
EXPOSE 8080
ENTRYPOINT ["java","-jar","network-graph.jar"]