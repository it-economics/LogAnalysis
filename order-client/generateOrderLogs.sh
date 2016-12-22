#!/bin/bash
while true
do
	curl "http://nginx:80/order"
	sleep $[ ( $RANDOM % 10 )  + 1 ]s
done
