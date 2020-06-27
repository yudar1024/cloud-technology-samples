sudo mkdir -p /var/zookeeper/data
sudo mkdir -p /var/zookeeper/log
sudo chown -R /var/zookeeper roger
tar -zxf apache-zookeeper-3.5.6-bin.tar.gz
mv apache-zookeeper-3.5.6-bin /opt/zookeeper-3.5.6
cp zoo.cfg /opt/zookeeper-3.5.6/conf
ssh roger@hadoop302 "sudo mkdir -p /var/zookeeper/data"
ssh roger@hadoop302 "sudo mkdir -p /var/zookeeper/log"
ssh roger@hadoop302 "sudo chown -R /var/zookeeper roger"
ssh roger@hadoop303 "sudo mkdir -p /var/zookeeper/data"
ssh roger@hadoop303 "sudo mkdir -p /var/zookeeper/log"
ssh roger@hadoop303 "sudo chown -R /var/zookeeper roger"
sudo rsync -aup -e "ssh -i /home/roger/.ssh/id_rsa" /opt/zookeeper-3.5.6 roger@hadoop302:/opt
sudo rsync -aup -e "ssh -i /home/roger/.ssh/id_rsa" /opt/zookeeper-3.5.6 roger@hadoop303:/opt
