package com.webetapi.api.controller;


import com.webetapi.api.kafka.AvroProducer;
import com.webetapi.api.model.Employee;
import com.webetapi.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
public class AvroController {

    private final AvroProducer producer;

    @Autowired
    AvroController (AvroProducer producer) {
        this.producer = producer;
        //this.consumer = consumer;
    }

    @PostMapping(value = "/postUser")
    public String postAvroMessage(@RequestBody Employee user){
        this.producer.send(user);
        return "Message published successfully";
    }
}



