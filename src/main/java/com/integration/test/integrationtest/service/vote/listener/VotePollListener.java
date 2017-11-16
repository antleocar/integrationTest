package com.integration.test.integrationtest.service.vote.listener;

import com.integration.test.integrationtest.service.poll.projection.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VotePollListener {

  @Autowired
  private VoteRepository voteRepository;

}
