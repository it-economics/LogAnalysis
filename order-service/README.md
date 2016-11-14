# OrderService

## Build

### Build Spring-Boot

```shell
gradle build
```

### Build Docker Image  

```shell
gradle buildDocker
```

## Run

```shell
java -jar build/libs/gs-spring-boot-docker-0.1.0.jar
```

### Run via Docker

If you did 'gradle buildDocker' you can run the created image via this command:

```shell
docker run -d -p 8081:8081 iteloganalysis/order-service
```

## Use

With a running application you can use your browser to generate log sample messages.

### Generate simple log messages

Simple log message can be generate using a REST api. Navigating to [http://localhost:8081/log/info](http://localhost:8081/log/info) will let you produce a info message.
To generate a warning message you can use [http://localhost:8081/log/warn](http://localhost:8081/log/warn). Via [http://localhost:8081/log/error](http://localhost:8081/log/error) you can generate an error message. 

### Generate order process logs

To generate example of an order process logs you can use also a REST api too. Go to [http://localhost:8081/order](http://localhost:8081/order) in order to generate order log messages.

