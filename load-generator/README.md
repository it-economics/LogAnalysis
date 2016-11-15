# load-generator

## Preconditions

Start your system under test with [docker-compose](..) and scale the containers to your needs.

### Run  

Run the [gatling](http://gatling.io/#/) to generate logs/load:

```shell
cd $(this-project-directory)
gradle gatlinRun
```

#### Run with Parameters

You can use the following parameters:

* baseURL
* userCount

Example with the default values:

```shell
cd $(this-project-directory)
gradle gatlinRun -DbaseURL=http://localhost:8082 -DuserCount=100
```
