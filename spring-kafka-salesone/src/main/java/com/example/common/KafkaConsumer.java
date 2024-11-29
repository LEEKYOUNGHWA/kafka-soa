package com.example.common;

import com.example.model.Member;
import com.example.model.Team;
import com.example.repository.MemberRepository;
import com.example.repository.TeamRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @KafkaListener(topics = "hr-member-update-dev-v1", groupId = "salesone-member-update-dev")
    public void receive(String message) {
        logger.info("Received message: " + message);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Member memberVO = objectMapper.readValue(message, Member.class);
            memberRepository.save(memberVO);
            logger.info("Saved message: " + message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @KafkaListener(topics = "hr-team-update-dev-v1", groupId = "salesone-team-update-dev")
    public void receiveTeam(String message) {
        try {
            logger.info("Received message: " + message);
            ObjectMapper objectMapper = new ObjectMapper();
            Team teamrVO = objectMapper.readValue(message, Team.class);
            teamRepository.save(teamrVO);
            logger.info("Saved message");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
