package com.example.repository;

import com.example.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Member save(Member memberVo);
}