# log-analysis

## Build

### Build Docker Images  

Run the gradle command in each directory in the following order:

* kibana
* logstash

  gradle buildDocker

  ```shell
  cd $(project-root)
  gradle buildDocker
  ```

You can build everything together with the gradle parent project.
