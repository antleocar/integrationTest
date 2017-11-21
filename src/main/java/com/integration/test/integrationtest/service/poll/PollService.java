package com.integration.test.integrationtest.service.poll;

import com.google.common.eventbus.EventBus;
import com.integration.test.integrationtest.domain.Event;
import com.integration.test.integrationtest.domain.EventStore;
import com.integration.test.integrationtest.domain.poll.Poll;
import com.integration.test.integrationtest.service.poll.command.CreateVoteCommand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PollService {

  private EventStore eventStore;
  private EventBus eventBus;

  public Poll process(CreateVoteCommand pollCommand) {
    Optional<Poll> poll = loadPoll(pollCommand.getIdPoll());
    poll.get().getVotes().put(pollCommand.getPollOption(), pollCommand.getVote());
    storeEvents(poll.get());
    return poll.get();
  }

  public Optional<Poll> loadPoll(String id) {
    List<Event> eventPoll = eventStore.load(id);
    return !eventPoll.isEmpty() ? Optional.of(new Poll(id, eventPoll)) : Optional.empty();
  }

  private void storeEvents(Poll poll) {
    eventStore.store(UUID.randomUUID().toString(), poll.getNewEventsList(), poll.getBaseVersion());
    eventBus.post(poll);
  }


}
