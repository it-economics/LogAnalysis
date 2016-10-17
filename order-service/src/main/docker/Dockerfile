FROM java:8-jdk

VOLUME /tmp

ADD gs-spring-boot-docker-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'

# installing filebeat
COPY install-filebeat.sh /install/install-filebeat.sh
RUN chmod +x /install/install-filebeat.sh \
    && /install/install-filebeat.sh \
    && rm /install/install-filebeat.sh

ENTRYPOINT ["java","-jar","/app.jar"]
