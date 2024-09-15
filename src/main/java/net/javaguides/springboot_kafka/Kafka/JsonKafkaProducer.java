package net.javaguides.springboot_kafka.Kafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot_kafka.payload.User;

@Service
public class JsonKafkaProducer {
   
 private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String,User>kafkaTemplate;

    //no need to write @Autowired annotation as this constructor has only one paramete
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }   

    public void sendMessage(User data){
        LOGGER.info(String.format("Message sent -> %s", data.toString()));
        Message<User>message=MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "yogi_json").build();
//here yogi is topic name
        kafkaTemplate.send(message);  
    }
}
