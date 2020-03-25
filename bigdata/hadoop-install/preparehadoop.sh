# yum install -y java-1.8.0-openjdk-devel.x86_64 java-1.8.0-openjdk.x86_64
# yum install -y rsync
sudo chown -R roger /opt
sudo chown -R roger /var/log
sudo echo "export HADOOP_HOME=/opt/hadoop-3.2.1" >> /etc/profile
sudo echo "export PATH=$PATH:$HADOOP_HOME/bin" >> /etc/profile 
sudo echo "export PATH=$PATH:$HADOOP_HOME/sbin" >> /etc/profile
sudo echo "export JAVA_HOME=/usr/lib/jvm/jre-1.8.0" >> /etc/profile
sudo echo "export ZOOKEEPER_HOME=/opt/zookeeper-3.5.6" >> /etc/profile
sudo echo "export PATH=$PATH:$ZOOKEEPER_HOME/bin" >> /etc/profile
mkdir -p /tmp/hadoop/tmpdir
mkdir -p /tmp/hadoop/pid
mkdir -p /tmp/hadoop/journalnode/data
mkdir -p /tmp/hadoop/hdfs/namenode
mkdir -p /tmp/hadoop/hdfs/datanode
mkdir -p /tmp/zookeeper
mkdir -p /var/log/hadoop

name=$(hostname)
index=${name:0-1:1}
echo $index > /tmp/zookeeper/myid

