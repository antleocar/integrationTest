package com.integration.test.integrationtest.domain.poll.event;

import com.integration.test.integrationtest.domain.Event;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class VoteEvent extends Event {

  @Id
  private String idVoteEvent;
  private Long creationMoment;

  public VoteEvent(String aggregateId, Long time, int version, String idVoteEvent, Long creationMoment) {
    super(aggregateId, time, version);
    this.idVoteEvent = idVoteEvent;
    this.creationMoment = creationMoment;
  }


}
