package com.integration.test.integrationtest.service.poll;

import com.integration.test.integrationtest.domain.Event;
import com.integration.test.integrationtest.domain.EventStore;
import com.integration.test.integrationtest.domain.poll.Poll;
import com.integration.test.integrationtest.service.poll.command.CreateVoteCommand;
import com.integration.test.integrationtest.service.poll.command.PollCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.Data;

@Service
public class PollService {

  private EventStore eventStore;

  public Poll process(CreateVoteCommand pollCommand) {
    Optional<Poll> poll = loadPoll(pollCommand.getIdPoll());
    storeEvents(poll.get());
    return poll.get();
  }

  public Optional<Poll> loadPoll(String id) {
    List<Event> eventPoll = eventStore.load(id);
    return !eventPoll.isEmpty() ? Optional.of(new Poll(id, eventPoll)) : Optional.empty();
  }

  private void storeEvents(Poll poll) {
    eventStore.store(UUID.randomUUID().toString(), poll.getNewEventsList(), poll.getBaseVersion());
  }


}
