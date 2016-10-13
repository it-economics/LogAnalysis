FROM iteloganalysis/java
ADD install.sh /tmp/install.sh
RUN chmod u+rwx /tmp/install.sh && /tmp/install.sh && rm /tmp/install.sh
ENV CATALINA_BASE /var/lib/tomcat7
ENV CATALINA_HOME /usr/share/tomcat7
ENTRYPOINT ["/usr/share/tomcat7/bin/catalina.sh"]
CMD ["run"]
EXPOSE 8080
