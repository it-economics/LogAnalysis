FROM kibana:5.0.1

COPY kibana.yml /etc/kibana/kibana.yml
COPY kibana-entrypoint.sh /kibana-entrypoint.sh
COPY load-kibana-dashboards.sh /load-kibana-dashboards.sh

RUN apt-get update && apt-get install -y netcat
RUN chmod +x /load-kibana-dashboards.sh && chmod +x /kibana-entrypoint.sh && /load-kibana-dashboards.sh

ENTRYPOINT /kibana-entrypoint.sh
