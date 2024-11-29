package com.example.controller;

import com.example.repository.MemberRepository;
import com.example.model.Member;
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
@RequestMapping("/member")
public class MemberController {

    private final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final KafkaProducer kafkaProducer;

    @Autowired
    public MemberController(KafkaProducer kafkaProducer) {

        this.kafkaProducer = kafkaProducer;
    }

    @Autowired
    MemberRepository repo;

    @GetMapping
    public List<Member> getAllMembers() {
        return (List<Member>) repo.findAll();
    }

    @PostMapping
    public ResponseEntity<String> saveMember(@RequestBody List<Member> members) {

        members.forEach( memberVO -> {
            repo.save(memberVO);
            kafkaProducer.send("hr-member-update-dev-v1", memberVO);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body("Members processed and sent to Kafka successfully.");
    }
}
