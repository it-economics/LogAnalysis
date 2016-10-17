#!/bin/bash

apt-get update
apt-get install -y curl unzip

curl -L -O http://download.elastic.co/beats/dashboards/beats-dashboards-1.3.1.zip
unzip beats-dashboards-1.3.1.zip

rm beats-dashboards-1.3.1.zip
