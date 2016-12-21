#!/bin/bash

# captured from https://github.com/deviantony/docker-elk/blob/master/kibana/entrypoint.sh ;)
# Wait for the Elasticsearch container to be ready before starting Kibana.
echo "Stalling for Elasticsearch"
while true; do
    echo "Waiting for elasticsearch to become available"
    sleep 3
    nc -q 1 elasticsearch 9200 2>/dev/null && break
done

echo "Importing search, visualization and dashboard into Kibana"
curl -XPUT 'http://elasticsearch:9200/.kibana/search/All-Log-Events' -d @/All-Log-Events.json --header "Content-Type: application/json"
curl -XPUT 'http://elasticsearch:9200/.kibana/visualization/All-Log-Events-per-time' -d @/All-Log-Events-per-time.json --header "Content-Type: application/json"
curl -XPUT 'http://elasticsearch:9200/.kibana/dashboard/All-Log-Events-Dashboard' -d @/All-Log-Events-Dashboard.json --header "Content-Type: application/json"

/docker-entrypoint.sh kibana
