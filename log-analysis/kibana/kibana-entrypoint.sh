#!/bin/bash

cd beats-dashboards-1.3.1/
./load.sh -url elasticsearch:9200

/data/kibana/bin/kibana
