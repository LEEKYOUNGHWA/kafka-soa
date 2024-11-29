package com.example.repository;

import com.example.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
    Team save(Team memberVo);
}