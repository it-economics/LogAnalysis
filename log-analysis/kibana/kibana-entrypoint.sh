#!/bin/bash

# captured from https://github.com/deviantony/docker-elk/blob/master/kibana/entrypoint.sh ;)
# Wait for the Elasticsearch container to be ready before starting Kibana.
echo "Stalling for Elasticsearch"
while true; do
    nc -q 1 elasticsearch 9200 2>/dev/null && break
done

cd beats-dashboards-1.3.1/
./load.sh -url elasticsearch:9200

/docker-entrypoint.sh kibana
