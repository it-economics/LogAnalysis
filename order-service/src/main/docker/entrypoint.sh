#!/bin/bash

touch /var/log/app-stdout.log

echo 'Starting filebeat'
/etc/init.d/filebeat start

echo 'Starting spring boot app'
echo 'Outputs are redirected to /var/log/'
java -jar /app.jar 2> /var/log/app-error.log > /var/log/app-stdout.log
