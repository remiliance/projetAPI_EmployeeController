package com.webetapi.api.kafka;

import com.webetapi.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;



public class AvroProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AvroProducer.class);
    private static final String TOPIC = "topicRemil2";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void send(User user) {
        LOGGER.info("sending user='{}'", user.toString());
        kafkaTemplate.send(TOPIC, user);
    }
}
