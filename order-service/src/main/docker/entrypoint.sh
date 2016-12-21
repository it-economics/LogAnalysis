#!/bin/bash

# captured from https://github.com/deviantony/docker-elk/blob/master/kibana/entrypoint.sh ;)
# Wait for the Elasticsearch container to be ready before interacting with it.
while true; do
    echo "Waiting for elasticsearch to become available"
    sleep 3
    nc -q 1 elasticsearch 9200 2>/dev/null && break
done

echo "Elasticsearch ready!"
# "Publishing filebeat template"
# curl -XPUT 'http://elasticsearch:9200/_template/filebeat?pretty' -d@/etc/filebeat/filebeat.template.json
curl -XPUT 'http://elasticsearch:9200/_ingest/pipeline/loganalysis' -d'{
                                                                         "description" : "Pipeline to ingest Logevents",
                                                                         "processors": [
                                                                           ]
                                                                       }'
echo 'Starting filebeat'
/etc/init.d/filebeat start

echo 'Starting spring boot app'
echo 'Outputs are also written to /var/log/app-error.log'
java -jar /app.jar 2>&1 | tee /var/log/app-error.log
