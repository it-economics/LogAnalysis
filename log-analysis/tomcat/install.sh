BUILD_PACKAGES=tomcat7
apt-get update
apt-get install -y -qq $BUILD_PACKAGES
AUTO_ADDED_PACKAGES=`apt-mark showauto`
apt-get remove --purge -y $BUILD_PACKAGES $AUTO_ADDED_PACKAGES
rm -rf /var/lib/apt/lists/*
