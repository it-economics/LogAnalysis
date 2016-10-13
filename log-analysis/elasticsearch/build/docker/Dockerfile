FROM iteloganalysis/java
ADD install.sh /tmp/install.sh
RUN chmod u+rwx /tmp/install.sh && /tmp/install.sh && rm /tmp/install.sh
USER elasticsearch
CMD /data/elasticsearch/bin/elasticsearch
EXPOSE 9200
