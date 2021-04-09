package com.webetapi.api.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringProducer {

    /*private static final Logger logger = LoggerFactory.getLogger(StringProducer.class);
    private static final String TOPIC = "topicRemil2";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        logger.info(String.format("$$ -> Producing message --> %s",message));
        this.kafkaTemplate.send(TOPIC,message);
    }*/



}
