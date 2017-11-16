package com.integration.test.integrationtest.domain.poll;

import com.integration.test.integrationtest.domain.Aggregate;
import com.integration.test.integrationtest.domain.Event;
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

  public Poll(UUID uuid, String idPoll, List<String> idVotes) {
    super(uuid);
    PollConsumeEvent pollConsumeEvent = new PollConsumeEvent(uuid, System.currentTimeMillis(), nextBaseVersion(), idPoll, idVotes);
    applyNewEvent(pollConsumeEvent);
  }

  public Poll(UUID idPoll, List<Event> eventStream) {
    super(idPoll, eventStream);
  }

}
