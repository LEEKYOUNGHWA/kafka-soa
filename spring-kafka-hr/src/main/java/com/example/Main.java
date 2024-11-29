package com.example;

import com.example.model.Member;
import com.example.model.Team;
import com.example.repository.MemberRepository;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @PostConstruct
    public void init() {
        // H2 DB에 10000개의 멤버 데이터 삽입
        IntStream.range(1, 10001).forEach(i -> {
            Member member = new Member(i+"", "hr이름" + i);
            memberRepository.save(member);

            Team team = new Team(i+"", "hr팀" + i);
            teamRepository.save(team);
        });
    }


}
