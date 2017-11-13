package com.integration.test.integrationtest.domain.poll.event;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class VoteEvent {

  @Id
  private String idVoteEvent;
  private Long creationMoment;


}
