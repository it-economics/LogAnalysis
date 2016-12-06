# LogAnalysis

Sample project to show the basic aspects of the ELK Stack (Elasticsearch, Logstash, Kibana).
To generate log output, the project contains a minimal spring boot application.
All services are setup using Docker.

## Getting started

### URLs

The services are reachable under following URLs.

* order-service: [http://localhost:8082](http://localhost:8082)
* Kibana: [http://localhost:5601](http://localhost:5601)

### Building Docker images

You can use _docker-compose_ to start all service containers.
Before you can do that, build the kibana, logstash and the order-service Docker images.
Then create containers of them using docker-compose.

```shell
cd $(project-root)
gradle buildDocker
docker-compose up -d
```
You can NOT start Containers alone, because the entrypoint scripts are dependent on elasticsearch and wait for it to startup.

### Defining Kibana index pattern

At startup Kibana is asking for an index pattern. Enter "filebeat-\*" in the field "Index name or pattern" and click on create.
That's it. Now you can explore the log entries.

### Generating log messages with order-service app

#### Generating log messages manually
Generarting log message can be done by using a REST api. You can lƒog sample output by hitting different urls like [http://localhost:{randomPort}/log/{log-level}](http://localhost:{randomPort}/log/{log-level}) in your browser. As log levels you can use _info_, _warn_ and _error_. Each request on these urls will create a new log entry according to specified log level. Via a the url [http://localhost:{randomPort}/order](http://localhost:{randomPort0/order) you can run a service which simulates an order-process logging several log messages and exceptions.

We don't use a fixed port (e.g. 8080), because we want to be able to scale the order-service app and create log output on different "hosts".

#### Generating log messages using Gatling
In order to create a bunch of log messages automatically you can use [Gatling](http://gatling.io/#/). With these, each url of the REST api is triggered several times. Just run Gatling like this.

```shell
cd $(project-root)/load-generator
gradle gatlinRun
```

All generated log messages will be automatically forwared to Elasticsearch and Kibana.

### Scaling order-service

You can again use _doker-compose_ to scale the order-service app and fire up more docker containers. You can do this like so:

```shell
docker-compose up -d
docker-compose scale order_service=5
```

This will create an additional of four order-service containers and assign a random port to each of it. To start log generation, you first have to check, which ports docker assigned to your containers. In the following example screenshot, you can see the kibana, logstash, elasticsearch and five order-service containers. In this example docker assigned ports from 32773 to 32777 and redirects them to port 8081 in the container. So hitting
[http://localhost:32777/order](http://localhost:32777/order) will start simulation the order process on order-service container 3.

![example output of docker ps](./images/docker-ps.png?raw=true "Example output of docker ps")

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
