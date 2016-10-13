FROM ubuntu:14.04

# Install Java.
ADD install.sh /tmp/install.sh
RUN chmod u+rwx /tmp/install.sh && /tmp/install.sh && rm /tmp/install.sh

# Define working directory.
WORKDIR /data

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

# Define default command.
CMD ["bash"]
