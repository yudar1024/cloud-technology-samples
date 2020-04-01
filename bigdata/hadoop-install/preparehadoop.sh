# yum install -y java-1.8.0-openjdk-devel.x86_64 java-1.8.0-openjdk.x86_64
# yum install -y rsync

sudo echo "export HADOOP_HOME=/opt/hadoop-3.2.1" >> ~/.bashrc
sudo echo "export JAVA_HOME=/usr/lib/jvm/jre-1.8.0" >> ~/.bashrc
sudo echo "export ZOOKEEPER_HOME=/opt/zookeeper-3.5.6" >> ~/.bashrc
sudo echo 'export PATH=$PATH:$ZOOKEEPER_HOME/bin' >> ~/.bashrc
sudo echo 'export PATH=$PATH:$HADOOP_HOME/bin' >> ~/.bashrc 
sudo echo 'export PATH=$PATH:$HADOOP_HOME/sbin' >> ~/.bashrc

mkdir -p /tmp/hadoop/tmpdir
mkdir -p /tmp/hadoop/pid
mkdir -p /tmp/hadoop/journalnode/data
mkdir -p /tmp/hadoop/hdfs/namenode
mkdir -p /tmp/hadoop/hdfs/datanode
mkdir -p /tmp/zookeeper
mkdir -p /var/log/hadoop
sudo chown -R roger:roger /tmp/zookeeper
sudo chown -R roger:roger /tmp/hadoop
sudo chown -R roger /opt
sudo chown -R roger /var/log
name=$(hostname)
index=${name:0-1:1}
echo $index > /tmp/zookeeper/myid

