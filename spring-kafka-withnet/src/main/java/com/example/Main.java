package com.example;

import com.example.model.Md;
import com.example.model.Member;
import com.example.model.Team;
import com.example.repository.MdRepository;
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

    @Autowired
    private MdRepository mdRepository;

    @PostConstruct
    public void init() {
        // H2 DB에 100개의 멤버 데이터 삽입
        IntStream.range(1, 101).forEach(i -> {

        	Member member = new Member(i+"", "이름" + i);
            memberRepository.save(member);

            Team team = new Team(i+"", "팀" + i);
            teamRepository.save(team);

            Md md = new Md(i+"", "Md" + i);
            mdRepository.save(md);
        });
    }


}
