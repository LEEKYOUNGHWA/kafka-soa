package com.example.controller;

import com.example.repository.MemberRepository;
import com.example.repository.TeamRepository;
import com.example.model.Member;
import com.example.model.Team;
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
@RequestMapping("/team")
public class TeamController {

    private final Logger logger = LoggerFactory.getLogger(TeamController.class);

    private final KafkaProducer kafkaProducer;

    @Autowired
    public TeamController(KafkaProducer kafkaProducer) {

        this.kafkaProducer = kafkaProducer;
    }

    @Autowired
    TeamRepository repo;

    @GetMapping
    public List<Team> getAllTeams() {
        return (List<Team>) repo.findAll();
    }
}
