# OrderService

## Build

### Build Spring-Boot

  gradle build

### Build Docker Image  

  gradle buildDocker

## Run

  java -jar build/libs/gs-spring-boot-docker-0.1.0.jar

### Run via Docker

If you did 'gradle buildDocker' you can run the created image via this command:

```shell
docker run -d -p 8081:8081 iteloganalysis/order-service
```

## Use

  With a running application you can use your browser to start and stop generating log sample messages.

### Generate simple log messages

  Go to http://localhost:8081/log/start to generate simple log messages.
  http://localhost:8081/log/stop will stop generation.

### Generate order process logs
  Go to http://localhost:8081/order/start to generate a order service log messages.
  http://localhost:8081/order/stop will stop generation.
