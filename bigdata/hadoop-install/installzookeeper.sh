tar -zxf apache-zookeeper-3.5.6-bin.tar.gz
mv apache-zookeeper-3.5.6-bin /opt/zookeeper-3.5.6
cp zoo.cfg /opt/zookeeper-3.5.6/conf
sudo rsync -aup -e "ssh -i /home/roger/.ssh/id_rsa" /opt/zookeeper-3.5.6 roger@hadoop302:/opt
sudo rsync -aup -e "ssh -i /home/roger/.ssh/id_rsa" /opt/zookeeper-3.5.6 roger@hadoop303:/opt
