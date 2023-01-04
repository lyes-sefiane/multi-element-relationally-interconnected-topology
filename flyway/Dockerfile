FROM flyway/flyway:9.10.2-alpine
LABEL maintainer="Lyes S."
ADD sql_versions /flyway/sqlf
USER root
RUN apk upgrade --update-cache --available && \
    rm -rf /var/cache/apk/*