FROM amazoncorretto:11-alpine
LABEL maintainer="The M.E.R.I.T"
WORKDIR api-gateway
COPY ./target/api-gateway-0.0.1.jar api-gateway.jar
RUN apk upgrade --update-cache --available && \
    rm -rf /var/cache/apk/*
EXPOSE 8080
ENTRYPOINT ["java","-jar","api-gateway.jar"]