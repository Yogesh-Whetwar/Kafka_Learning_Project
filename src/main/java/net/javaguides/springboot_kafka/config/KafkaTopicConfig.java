package net.javaguides.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    //yogi is topic name
    @Bean
    public NewTopic yogi(){
        return TopicBuilder.name("yogi")  //we can also do .partitions(10) to create partitions but here we 
        //are using default partitions probided by the kafka
        .build();
    }  
    @Bean
    public NewTopic yogijsonTopic(){
        return TopicBuilder.name("yogi_json")  //we can also do .partitions(10) to create partitions but here we 
        //are using default partitions probided by the kafka
        .build();
    }
    
}
