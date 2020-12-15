package kafkawd;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

import static kafkawd.Utils.getRandomName;

public class ProducerDW {
    public static void main(String[] args) {

        String bootstrapserver = "127.0.0.1:9092";
        String topicName = "digital-wristband";https://cevheribozoglan.medium.com/apache-kafka-digital-wristband-create-kafka-producer-and-consumer-from-linux-terminal-e2ccd2becb06
        System.out.println(topicName);

        //create producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapserver);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (Integer i = 0; i < Integer.MAX_VALUE; i++) {
            //create a producer record
            ProducerRecord<String, String> record = new ProducerRecord<>(topicName, getRandomName());

            //send data
            producer.send(record);

        }
        producer.flush();
        producer.close();
    }
}