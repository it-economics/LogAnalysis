# LogAnalysis

## Components

* Nginx-Frontend (TODO)
* order-service (Spring-Boot Applikation)
* loganalysis-service (TODO)

## Getting started

You can use _docker-compose_ to start three containers with different services.

### TL;DR
Build the kibana and the order-service Docker image. Then create containers of them using docker-compose.

```shell
cd $(project-root)/log-analysis/kibana/
gradle buildDocker

cd $(project-root)/order-service/
gradle buildDocker

cd $(project-root)/
docker-compose up -d
```
You can NOT start Containers alone, because the entrypoint scripts are dependent on elasticsearch and wait for it to startup.

### Prerequisites

Before you can run the services, you need to build the images. For elasticsearch, the official image is used.
All needed images can be build via _gradle buildDocker_. Just go to the subfolder in ./log-analysis.
To get an image with the example application, go to ./order-service and run _gradle buildDocker_.

### Services

* order_service
  * Example Spring-Boot application for log generation
  * Contains filebeat to publish log-entries to elasticsearch
* elasticsearch
  * Used to index log-entries
* kibana
  * UI to visualize log-entries
