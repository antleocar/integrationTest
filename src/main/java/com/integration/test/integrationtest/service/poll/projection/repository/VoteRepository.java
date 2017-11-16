package com.integration.test.integrationtest.service.poll.projection.repository;


import com.integration.test.integrationtest.domain.poll.Vote;
import com.integration.test.integrationtest.service.vote.projection.VoteProjection;
import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface VoteRepository extends MongoRepository<Vote, String> {

  List<VoteProjection> getVotes(UUID idPoll);

}
