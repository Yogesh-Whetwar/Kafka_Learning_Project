package net.javaguides.springboot_kafka.controller;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot_kafka.Kafka.JsonKafkaProducer;
// import net.javaguides.springboot_kafka.Kafka.KafkaProducer;
import net.javaguides.springboot_kafka.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
  
    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish( @RequestBody User user){
      jsonKafkaProducer.sendMessage(user);
      return ResponseEntity.ok("Json Message sent to kafka topic");
    }

}
