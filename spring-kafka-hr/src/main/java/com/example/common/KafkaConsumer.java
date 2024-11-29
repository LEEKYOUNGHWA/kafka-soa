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

//    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private TeamRepository teamRepository;
//
//    @KafkaListener(topics = "insa-member", groupId = "salesone")
//    public void receiveMember(String message) {
//        try {
//            logger.info("Received message: " + message);
//            ObjectMapper objectMapper = new ObjectMapper();
//            MemberVO memberVO = objectMapper.readValue(message, MemberVO.class);
//            memberRepository.save(memberVO);
//            logger.info("Saved message");
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @KafkaListener(topics = "insa-team", groupId = "salesone")
//    public void receiveTeam(String message) {
//        try {
//            logger.info("Received message: " + message);
//            ObjectMapper objectMapper = new ObjectMapper();
//            TeamVO teamrVO = objectMapper.readValue(message, TeamVO.class);
//            teamRepository.save(teamrVO);
//            logger.info("Saved message");
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
