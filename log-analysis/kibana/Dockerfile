FROM iteloganalysis/tomcat
RUN apt-get install -qq -y wget
RUN wget -nv https://download.elastic.co/kibana/kibana/kibana-4.6.1-linux-x86_64.tar.gz ; tar xzf kibana-4.6.1-linux-x86_64.tar.gz -C /var/lib/tomcat7/webapps
ADD index.html /var/lib/tomcat7/webapps/ROOT/
CMD JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64 CATALINA_BASE=/var/lib/tomcat7 CATALINA_HOME=/usr/share/tomcat7 /usr/share/tomcat7/bin/catalina.sh run
EXPOSE 8080
