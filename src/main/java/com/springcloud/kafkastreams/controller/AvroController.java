package com.springcloud.kafkastreams.controller;

import com.springcloud.kafkastreams.producer.AvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class AvroController {

    @Autowired
    private AvroProducer avroProducer;

    @PostMapping("/{id}/{firstName}/{lastName}")
    public String producerAvroMessage(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName) {
        avroProducer.produceEmployeeDetails(id, firstName, lastName);
        return "Sent employee details to consumer";
    }

}
