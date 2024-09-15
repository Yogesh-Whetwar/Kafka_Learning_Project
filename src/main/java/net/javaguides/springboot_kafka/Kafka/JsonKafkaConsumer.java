package net.javaguides.springboot_kafka.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import net.javaguides.springboot_kafka.payload.User;

@Service
public class JsonKafkaConsumer {  
    private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaConsumer.class);
  
    @KafkaListener(topics = "yogi_json",groupId = "myGroup")
    public void consume(User user){
      LOGGER.info(String.format("Json msg received -> %s", user.toString()));
      
    }

}
