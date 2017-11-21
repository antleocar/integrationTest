package com.integration.test.integrationtest.domain.poll;

import com.integration.test.integrationtest.domain.Aggregate;
import com.integration.test.integrationtest.domain.Event;
import com.integration.test.integrationtest.domain.poll.event.PollConsumeEvent;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Poll extends Aggregate implements Serializable {

  @Id
  private String idPoll;
  private List<String> pollOptions;
  private Map<String, Integer> votes;

  public Poll(String uuid, String idPoll, List<String> pollOptions, Map<String, Integer> votes) {
    super(uuid);
    PollConsumeEvent pollConsumeEvent = new PollConsumeEvent(uuid, System.currentTimeMillis(), nextBaseVersion(), idPoll, pollOptions, votes);
    applyNewEvent(pollConsumeEvent);
  }

  public Poll(String idPoll, List<Event> eventStream) {
    super(idPoll, eventStream);
  }

}
