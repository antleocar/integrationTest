package com.integration.test.integrationtest.infrastructure.repository;


import com.integration.test.integrationtest.domain.poll.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface VoteRepository extends MongoRepository<Vote, String> {

}
