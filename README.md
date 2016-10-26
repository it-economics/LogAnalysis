# LogAnalysis

Sample project to show the basic aspects of the ELK Stack (Elasticsearch, Logstash, Kibana).
To generate log output, the project contains a minimal spring boot application.
All services are setup using Docker.

## Getting started

### URLs

The services are reachable under following URLs.

* order-service: [http://localhost:8081](http://localhost:8081)
* Kibana: [http://localhost:5601](http://localhost:5601)

### Building Docker images

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

### Defining Kibana index pattern

At startup Kibana is asking for an index pattern. Enter "filebeat-\*" in the field "Index name or pattern" and click on create.
That's it. Now you can explore the log entries.

### Generating log messages with order-service app

You can start log output creation by hitting [http://localhost:8081/log/start](http://localhost:8081/log/start) in your browser.
You can stop it by hitting [http://localhost:8081/log/stop](http://localhost:8081/log/stop).
Via [http://localhost:8081/order/start](http://localhost:8081/order/start) and [http://localhost:8081/order/stop](http://localhost:8081/order/stop), you can start and stop a service which simulates a order-process with log-entries and exceptions.

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
