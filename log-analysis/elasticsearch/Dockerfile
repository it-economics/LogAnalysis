FROM iteloganalysis/java
RUN apt-get install -qq -y wget
RUN wget -nv https://download.elastic.co/elasticsearch/release/org/elasticsearch/distribution/tar/elasticsearch/2.4.1/elasticsearch-2.4.1.tar.gz ; tar xzf elasticsearch-2.4.1.tar.gz
CMD elasticsearch-2.4.1/bin/elasticsearch
EXPOSE 9200
