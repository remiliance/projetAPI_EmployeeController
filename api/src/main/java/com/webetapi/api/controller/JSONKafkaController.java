package com.webetapi.api.controller;


import com.webetapi.api.kafka.JsonItemConsumer;
import com.webetapi.api.kafka.JsonItemProducer;
import com.webetapi.api.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer")
public class JSONKafkaController {

  /*  private final JsonItemProducer producer;
    private final JsonItemConsumer consumer;

    @Autowired
    JSONKafkaController(JsonItemProducer producer, JsonItemConsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @PostMapping(value = "/postItem")
    public String postJsonMessage(@RequestBody Item item){
          this.producer.sendMessage(item);
        return "Message published successfully";
    }*/
}
