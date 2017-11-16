package com.integration.test.integrationtest.service.poll;

import com.integration.test.integrationtest.domain.Event;
import com.integration.test.integrationtest.domain.EventStore;
import com.integration.test.integrationtest.domain.poll.Poll;
import com.integration.test.integrationtest.service.poll.command.PollCommand;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.Data;

@Data
public class PollService {

  private final EventStore eventStore;

  public Poll process(PollCommand pollCommand) {
    Poll poll = new Poll(UUID.randomUUID(), pollCommand.getIdPoll(), pollCommand.getIdVotes());
    storeEvents(poll);
    return poll;
  }

  public Optional<Poll> loadPoll(UUID id) {
    List<Event> eventPoll = eventStore.load(id);
    return !eventPoll.isEmpty() ? Optional.of(new Poll(id, eventPoll)) : Optional.empty();
  }

  private void storeEvents(Poll poll) {
    eventStore.store(UUID.randomUUID(), poll.getNewEventsList(), poll.getBaseVersion());
  }


}
