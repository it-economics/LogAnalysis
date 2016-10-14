# OrderService

## Build

### Build Spring-Boot

  gradle build

### Build Docker Image  

  gradle buildDocker

## Run

  java -jar build/libs/gs-spring-boot-docker-0.1.0.jar
  
## Generate Simple Logs
  
  Go to http://localhost:8080/log/start to generate simple log messages. 
  http://localhost:8080/log/stop will stop generation.
  
## Generate example Order Logs
  Go to http://localhost:8080/order/start to generate a order service log messages. 
  http://localhost:8080/order/stop will stop generation.