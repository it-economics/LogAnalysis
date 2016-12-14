FROM java:8-jdk

# installing netcat
RUN apt-get update --fix-missing && apt-get install -y netcat

ADD gs-spring-boot-docker-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'

# installing filebeat
COPY install-filebeat.sh /install/install-filebeat.sh
RUN chmod +x /install/install-filebeat.sh 
RUN /install/install-filebeat.sh
RUN rm /install/install-filebeat.sh


COPY filebeat.yml /etc/filebeat/filebeat.yml
COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh

# run app and redirect stderr to error.txt and stdout to stdout.txt
ENTRYPOINT ["/entrypoint.sh"]
