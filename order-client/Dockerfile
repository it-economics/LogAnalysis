FROM debian

RUN apt-get update && apt-get install -y curl

COPY generateOrderLogs.sh /usr/local/sbin/generateOrderLogs.sh
RUN chmod +x /usr/local/sbin/generateOrderLogs.sh

ENTRYPOINT ["/usr/local/sbin/generateOrderLogs.sh"]