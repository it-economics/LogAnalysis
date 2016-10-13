FROM iteloganalysis/java
ADD install.sh /tmp/install.sh
RUN chmod u+rwx /tmp/install.sh && /tmp/install.sh && rm /tmp/install.sh
ENTRYPOINT ["/data/kibana/bin/kibana"]
EXPOSE 5601
