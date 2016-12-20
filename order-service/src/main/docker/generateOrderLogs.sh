#!/bin/bash
while true
do
	curl "http://localhost:8081/order"
	sleep $[ ( $RANDOM % 10 )  + 1 ]s
done