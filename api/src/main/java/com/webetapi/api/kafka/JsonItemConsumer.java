package com.webetapi.api.kafka;

import com.webetapi.api.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class JsonItemConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonItemConsumer.class);

    @KafkaListener(topics = "topicRemil3")
    public void receive(Item item)
   // public void receive(String string)
    {
        LOGGER.info("received item'{}'", item.toString());
        LOGGER.info("received item'{}'", item.getName());
    }
}
