package com.integration.test.integrationtest.eventStore;

import com.google.common.collect.ImmutableList;
import com.integration.test.integrationtest.domain.Event;
import com.integration.test.integrationtest.domain.EventStore;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.dao.OptimisticLockingFailureException;

public class InMemoryEventStore implements EventStore {

  private Map<String, List<Event>> eventsStore = new ConcurrentHashMap<>();

  @Override
  public void store(String aggregateId, List<Event> newEventList, int baseVersion)
      throws OptimisticLockingFailureException {
    eventsStore.merge(aggregateId, newEventList, (oldValue, value) -> {
      if (baseVersion != oldValue.get(oldValue.size() - 1).getVersion()) {
        throw new OptimisticLockingFailureException("Base version doesn't match with current stored version");
      }
      return Stream.concat(oldValue.stream(), value.stream()).collect(Collectors.toList());
    });
  }

  @Override
  public List<Event> load(String aggregateId) {
    return ImmutableList.copyOf(eventsStore.getOrDefault(aggregateId, Collections.emptyList()));
  }
}
