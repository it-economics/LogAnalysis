ES_BASENAME=elasticsearch-2.4.1
ES_ARCHIVE=$ES_BASENAME'.tar.gz'
wget -nv https://download.elastic.co/elasticsearch/release/org/elasticsearch/distribution/tar/elasticsearch/2.4.1/$ES_ARCHIVE
tar xzf $ES_ARCHIVE -C /data
rm $ES_ARCHIVE
ln -s /data/$ES_BASENAME /data/elasticsearch
useradd elasticsearch
chown -R elasticsearch:elasticsearch /data/
