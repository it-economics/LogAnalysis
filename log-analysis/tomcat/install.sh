BUILD_PACKAGES=tomcat7
apt-get update
apt-get install -y -qq $BUILD_PACKAGES
apt-get autoclean -y
rm -rf /var/lib/apt/lists/*
