package com.integration.test.integrationtest.domain.poll.event;

import com.integration.test.integrationtest.domain.Event;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators.In;

@Data
public class PollConsumeEvent extends Event {

  private String idPoll;
  private List<String> pollOptions;
  private Map<String, Integer> votes;

  public PollConsumeEvent(String aggregateId, Long time, int version, String idPoll,
      List<String> pollOptions, Map<String, Integer> votes) {
    super(aggregateId, time, version);
    this.idPoll = idPoll;
    this.pollOptions = pollOptions;
    this.votes = votes;
  }

}
