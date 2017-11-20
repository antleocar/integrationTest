package com.integration.test.integrationtest.domain.poll.event;

import com.integration.test.integrationtest.domain.Event;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class PollConsumeEvent extends Event {

  private String idPoll;
  private List<String> idVotes;

  public PollConsumeEvent(String aggregateId, Long time, int version, String idPoll, List<String> idVotes) {
    super(aggregateId, time, version);
    this.idPoll = idPoll;
    this.idVotes = idVotes;
  }

}
