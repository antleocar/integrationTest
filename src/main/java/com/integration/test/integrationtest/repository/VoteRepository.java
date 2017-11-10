package com.integration.test.integrationtest.repository;


import com.integration.test.integrationtest.domain.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface VoteRepository extends MongoRepository<Vote, String> {

}
