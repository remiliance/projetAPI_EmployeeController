package com.webetapi.api.kafka;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.webetapi.api.model.Item;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
@EnableKafka
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    //************************
    // Message String
    //************************

    @Bean
    public ProducerFactory<String, Object> producerFactory(){
        Map<String, Object> config = new HashMap<>();
        //      list of host:port pairs used for establishing the initial connections to the Kakfa cluster
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(config);
    }


    //Factory pour les strings
    @Bean
    public ProducerFactory<String, String> producerFactoryMSG() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    //factory pour les JSONDefaultKafkaProducerFactory
    @Bean
    public ProducerFactory<String, Item> producerFactoryJSON() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    ////Template pour les strings
    @Bean
    public KafkaTemplate<String, String> kafkaTemplateMSG() {
        return new KafkaTemplate<>(producerFactoryMSG());
    }

    ///Template pour le JSON
    @Bean
    public KafkaTemplate<String, Item> kafkaTemplateJSON(){
        return new KafkaTemplate<>(producerFactoryJSON());
    }

    @Bean
    public StringProducer producer() {
        return new StringProducer();
    }

}
