BUILD_PACKAGES=oracle-java8-installer
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
apt-get update
apt-get install -y software-properties-common
apt-get install -y wget
add-apt-repository -y ppa:webupd8team/java
apt-get update
apt-get install -y $BUILD_PACKAGES
AUTO_ADDED_PACKAGES=`apt-mark showauto`
apt-get remove --purge -y $BUILD_PACKAGES $AUTO_ADDED_PACKAGES wget software-properties-common
rm -rf /var/lib/apt/lists/*
