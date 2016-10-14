# log-analysis

## Build

### Build Docker Images  

Run the gradle command in each directory in the following order:

* java
* elasticsearch
* kibana
* filebeat (TBD)
* tomcat (obsolete)

  gradle buildDocker

## Run

* TBD

## TODO

* build base image (Sebastian)
* apply DRY to build.gradle files (Hardi)
* add docker-compose file (Sebastian)
* add parent gradle file to build all subprojects (Hardi)
* minimize size of our java image
* ...
