package com.example.controller;

import com.example.repository.MdRepository;
import com.example.model.Md;
import com.example.common.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/md")
public class MdController {

    private final Logger logger = LoggerFactory.getLogger(MdController.class);

    private final KafkaProducer kafkaProducer;

    @Autowired
    public MdController(KafkaProducer kafkaProducer) {

        this.kafkaProducer = kafkaProducer;
    }

    @Autowired
    MdRepository repo;

    @GetMapping
    public List<Md> getAllMds() {
        return (List<Md>) repo.findAll();
    }

    @PostMapping
    public ResponseEntity<String> saveMd(@RequestBody List<Md> members) {

        members.forEach( memberVO -> {
            repo.save(memberVO);
            kafkaProducer.send("salesone-md-update-dev-v1", memberVO);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body("Mds processed and sent to Kafka successfully.");
    }
}
