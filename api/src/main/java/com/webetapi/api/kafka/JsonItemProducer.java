package com.webetapi.api.kafka;

import com.webetapi.api.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class JsonItemProducer {

    private static final Logger logger = LoggerFactory.getLogger(StringProducer.class);
    private static final String TOPIC = "topicRemil3";

    @Autowired
    private KafkaTemplate<String, Item> kafkaTemplate;

    public void sendMessage(Item message){
        logger.info(String.format("$$ -> Producing message "));
        this.kafkaTemplate.send(TOPIC, message);
    }

}
