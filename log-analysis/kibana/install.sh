KIBANA_BASENAME=kibana-4.6.1-linux-x86_64
KIBANA_ARCHIVE=$KIBANA_BASENAME'.tar.gz'
wget -nv https://download.elastic.co/kibana/kibana/$KIBANA_ARCHIVE
tar xzf $KIBANA_ARCHIVE -C /data
rm $KIBANA_ARCHIVE
ln -s /data/$KIBANA_BASENAME /data/kibana
