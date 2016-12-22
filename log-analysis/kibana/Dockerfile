FROM kibana:5.1.1

COPY kibana.yml /etc/kibana/kibana.yml
COPY kibana-entrypoint.sh /kibana-entrypoint.sh

COPY All-Log-Events.json /All-Log-Events.json
COPY All-Log-Events-per-time.json /All-Log-Events-per-time.json
COPY All-Log-Events-Dashboard.json /All-Log-Events-Dashboard.json

COPY All-non-info-level-logs.json /All-non-info-level-logs.json
COPY All-non-info-level-logs-per-time.json /All-non-info-level-logs-per-time.json
COPY Log-Levels-per-time.json /Log-Levels-per-time.json
COPY Advanced-dashboard.json /Advanced-dashboard.json

RUN apt-get update && apt-get install -y netcat curl
RUN chmod +x /kibana-entrypoint.sh

ENTRYPOINT /kibana-entrypoint.sh
