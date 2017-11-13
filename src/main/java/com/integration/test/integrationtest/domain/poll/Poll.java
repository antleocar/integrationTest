package com.integration.test.integrationtest.domain.poll;

import com.integration.test.integrationtest.domain.Aggregate;
import com.integration.test.integrationtest.domain.poll.event.PollConsumeEvent;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Poll extends Aggregate {

  @Id
  private String idPoll;
  private List<String> idVotes;

  public Poll(String idPoll, List<String> idVotes) {
    UUID uuid = UUID.randomUUID();
    PollConsumeEvent pollConsumeEvent = new PollConsumeEvent(uuid, System.currentTimeMillis(), nextBaseVersion(), idPoll, idVotes);
    applyNewEvent(pollConsumeEvent);
  }

}
