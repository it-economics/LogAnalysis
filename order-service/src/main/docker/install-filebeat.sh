#!/bin/bash

curl -L -O https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-5.0.1-amd64.deb
dpkg -i filebeat-5.0.1-amd64.deb
rm filebeat-5.0.1-amd64.deb
