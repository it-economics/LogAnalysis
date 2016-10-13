FROM iteloganalysis/tomcat
RUN chmod u+rwx /tmp/install.sh && /tmp/install.sh && rm /tmp/install.sh
ADD index.html /var/lib/tomcat7/webapps/ROOT/
