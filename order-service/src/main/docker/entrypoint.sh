#!/bin/bash

# create empty logfile to secure proper start of filebeat
touch /var/log/app-stdout.log

# captured from https://github.com/deviantony/docker-elk/blob/master/kibana/entrypoint.sh ;)
# Wait for the Elasticsearch container to be ready before interacting with it.
echo "Stalling for Elasticsearch"
while true; do
    nc -q 1 elasticsearch 9200 2>/dev/null && break
done

#echo "Elasticsearch ready! Publishing filebeat template"
curl -XPUT 'http://elasticsearch:9200/_template/filebeat?pretty' -d@/etc/filebeat/filebeat.template.json

echo 'Starting filebeat'
/etc/init.d/filebeat start

echo 'Starting spring boot app'
echo 'Outputs are redirected to /var/log/'
java -jar /app.jar 2> /var/log/app-error.log > /var/log/app-stdout.log
