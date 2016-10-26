# LogAnalysis

Sample project to show the basic aspects of the ELK Stack (Elasticsearch, Logstash, Kibana).
To generate log output, the project contains a minimal spring boot application.
All services are setup using Docker.

## Getting started

You can use _docker-compose_ to start all service containers.
Before you can do that, build the kibana, logstash and the order-service Docker images.
Then create containers of them using docker-compose.

```shell
cd $(project-root)/log-analysis/kibana/
gradle buildDocker

cd $(project-root)/log-analysis/logstash/
gradle buildDocker

cd $(project-root)/order-service/
gradle buildDocker

cd $(project-root)/
docker-compose up -d
```
You can NOT start Containers alone, because the entrypoint scripts are dependent on elasticsearch and wait for it to startup.

## Services overview

* order_service
  * Example Spring-Boot application for log generation
  * Contains filebeat to publish log-entries to logstash
* logstash
  * filtering and slicing filebeat input
  * publish output to elasticsearch
* elasticsearch
  * Used to index log-entries
* kibana
  * UI to visualize log-entries
