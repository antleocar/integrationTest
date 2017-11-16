package com.integration.test.integrationtest.service.vote.projection;

import lombok.Data;

@Data
public class VoteProjection {

  private final String voteId;
  private final String pollId;
  private final int version;

}
