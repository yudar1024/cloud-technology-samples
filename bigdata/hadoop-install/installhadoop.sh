if [ ! -d /opt/hadoop-3.2.1 -a -f hadoop-3.2.1.tar.gz ] 
then
  tar -zxf hadoop-3.2.1.tar.gz
  mv hadoop-3.2.1 /opt
fi

if [ -d /opt/hadoop-3.2.1 ] 
then
  cp core-site.xml /opt/hadoop-3.2.1/etc/hadoop/
  cp hdfs-site.xml /opt/hadoop-3.2.1/etc/hadoop/
  cp yarn-site.xml /opt/hadoop-3.2.1/etc/hadoop/
  cp mapred-site.xml /opt/hadoop-3.2.1/etc/hadoop/
  echo 'export HADOOP_PID_DIR=/tmp/hadoop/pid' >> /opt/hadoop-3.2.1/etc/hadoop/hadoop-env.sh
  echo 'export HADOOP_LOG_DIR=/var/log/hadoop' >> /opt/hadoop-3.2.1/etc/hadoop/hadoop-env.sh
  echo 'export JAVA_HOME=/usr/lib/jvm/jre-1.8.0' >> /opt/hadoop-3.2.1/etc/hadoop/hadoop-env.sh
  echo 'export HDFS_NAMENODE_USER=roger' >> /opt/hadoop-3.2.1/etc/hadoop/hadoop-env.sh
  echo 'export HDFS_DATANODE_USER=roger' >> /opt/hadoop-3.2.1/etc/hadoop/hadoop-env.sh
  echo 'export HDFS_JOURNALNODE_USER=roger' >> /opt/hadoop-3.2.1/etc/hadoop/hadoop-env.sh
  echo 'export HDFS_ZKFC_USER=roger' >> /opt/hadoop-3.2.1/etc/hadoop/hadoop-env.sh

  echo 'export JAVA_HOME=/usr/lib/jvm/jre-1.8.0'  >> /opt/hadoop-3.2.1/etc/hadoop/yarn-env.sh
  echo 'export YARN_RESOURCEMANAGER_USER=roger'  >> /opt/hadoop-3.2.1/etc/hadoop/yarn-env.sh
  echo 'export YARN_NODEMANAGER_USER=roger'  >> /opt/hadoop-3.2.1/etc/hadoop/yarn-env.sh
  echo 'hadoop301' > /opt/hadoop-3.2.1/etc/hadoop/workers
  echo 'hadoop302' >> /opt/hadoop-3.2.1/etc/hadoop/workers
  echo 'hadoop303' >> /opt/hadoop-3.2.1/etc/hadoop/workers

  sudo rsync -aup -e "ssh -i /home/roger/.ssh/id_rsa" /opt/hadoop-3.2.1 roger@hadoop302:/opt
  sudo rsync -aup -e "ssh -i /home/roger/.ssh/id_rsa" /opt/hadoop-3.2.1 roger@hadoop303:/opt
else
  echo "please download hadoop-3.2.1.tar.gz, and put it in same folder of installhadoop.sh"
fi

echo 'export $PATH=$PATH:'




