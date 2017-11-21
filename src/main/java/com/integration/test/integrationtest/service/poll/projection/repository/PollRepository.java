package com.integration.test.integrationtest.service.poll.projection.repository;

import com.integration.test.integrationtest.domain.poll.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface PollRepository extends MongoRepository<Poll, String> {


}
