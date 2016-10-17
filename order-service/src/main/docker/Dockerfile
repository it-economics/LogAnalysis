FROM java:8-jdk

ADD gs-spring-boot-docker-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'

# installing filebeat
COPY install-filebeat.sh /install/install-filebeat.sh
RUN chmod +x /install/install-filebeat.sh \
    && /install/install-filebeat.sh \
    && rm /install/install-filebeat.sh

# run app and redirect stderr to error.log and stdout to stdout.log
CMD java -jar /app.jar 2> error.log > stdout.log
