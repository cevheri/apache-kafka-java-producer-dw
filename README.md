# apache-kafka-java-producer-dw


First, Download Apache Kafka : https://kafka.apache.org/downloads. 
For example : https://www.apache.org/dyn/closer.cgi?path=/kafka/2.6.0/kafka_2.13-2.6.0.tgz

---------------------------------------------------------
unzip files
tar -xzf kafka_2.13-2.6.0.tgz
cd kafka_2.13-2.6.0

---------------------------------------------------------
need Java 8+
# for debian, ubuntu, mint
sudo apt-get install openjdk-8-jdk

---------------------------------------------------------

Start the Kafka Environment
# Open new terminal 
bin/zookeeper-server-start.sh config/zookeeper.properties
---------------------------------------------------------
# Open another terminal
bin/kafka-server-start.sh config/server.properties
Create digital-wristband topic
for example: 1 broker, 5 partitions, 1 replication-factor
# Open another terminal
bin/kafka-topics.sh \
--create --zookeeper localhost:2181 \
--replication-factor 1 \
--partitions 5 \
--topic digital-wristband
Now, the zookeeper is running, a kafka broker is running, and a kafka topic has been created.

---------------------------------------------------------
Now let’s create 1 producer and a consumer from cli and show the relationship between each other.
# Open another ""PRODUCER"" terminal
➜  kafka_2.13-2.6.0 bin/kafka-console-producer.sh --broker-list localhost:9092 --topic digital-wristband 
>Fedora
>
# Open another ""CONSUMER"" terminal
➜  kafka_2.13-2.6.0 bin/kafka-console-consumer.sh --topic digital-wristband --from-beginning --bootstrap-server localhost:9092

---------------------------------------------------------
Now Start the java code

java -cp “/path/to/kafka/kafka_2.11-0.9.0.0/lib/*”:. ProducerDW.java digital-wristband 

