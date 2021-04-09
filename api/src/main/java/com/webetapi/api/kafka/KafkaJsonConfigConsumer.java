package com.webetapi.api.kafka;

import java.util.HashMap;
import java.util.Map;

import com.webetapi.api.model.Item;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class KafkaJsonConfigConsumer {

        @Value("${spring.kafka.bootstrap-servers}")
        private String bootstrapServers;

        @Bean
        public Map<String, Object> consumerConfigs() {
            Map<String, Object> props = new HashMap<>();
            props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
            props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
            props.put(ConsumerConfig.GROUP_ID_CONFIG, "json");
            props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
            return props;
        }

      /*  @Bean
        public ConsumerFactory<String, String> consumerFactory() {
            return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
                    new StringDeserializer());
        }
*/

    @Bean
    public ConsumerFactory<String, Item> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
                new JsonDeserializer<>(Item.class));
    }
/*
        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
            ConcurrentKafkaListenerContainerFactory<String, String> factory =
                    new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(consumerFactory());

            return factory;
        }
*/

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Item> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Item> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }

        @Bean
        public JsonItemConsumer receiver() {
            return new JsonItemConsumer();
        }
    }


