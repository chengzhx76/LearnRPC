# RPC Demo
学习RPC

# 启动 Zookeeper
解压：tar -zxvf zookeeper-3.4.6.tar.gz
配置：进入conf目录重命名 mv zoo_sample.cfg zoo.cfg
      修改zoo.cfg文件 dataDir=/home/cheng/zookeeper-3.4.6/data
启动：进入bin目录 ./zkServer.sh start
      [root@localhost bin]# ./zkServer.sh start
      JMX enabled by default
      Using config: /home/cheng/zookeeper-3.4.6/bin/../conf/zoo.cfg
      Starting zookeeper ... STARTED
查看是否启动：进入bin目录 ./zkServer.sh status
      [root@localhost bin]#  ./zkServer.sh status
      JMX enabled by default
      Using config: /home/cheng/zookeeper-3.4.6/bin/../conf/zoo.cfg
      Mode: standalone

停止：进入bin目录 ./zkServer.sh stop