FROM kibana:5.0.1

COPY kibana.yml /etc/kibana/kibana.yml
COPY kibana-entrypoint.sh /kibana-entrypoint.sh

RUN apt-get update && apt-get install -y netcat
RUN chmod +x /kibana-entrypoint.sh

ENTRYPOINT /kibana-entrypoint.sh
