package com.example.recruitment.repostitory;

import com.example.recruitment.entity.RequestCounter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestCounterRepository extends CrudRepository<RequestCounter, Integer> {
  Optional<RequestCounter> findByLOGIN(String login);



}
