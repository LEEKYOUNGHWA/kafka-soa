package com.example.repository;

import com.example.model.Md;
import com.example.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MdRepository extends CrudRepository<Md, Long> {
    Md save(Md memberVo);
}