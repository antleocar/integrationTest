package com.integration.test.integrationtest.domain;

import java.util.List;
import java.util.UUID;
import org.springframework.dao.OptimisticLockingFailureException;

public interface EventStore {

  void store(String aggregateId, List<Event> newEventList, int baseVersion) throws OptimisticLockingFailureException;
  List<Event> load(String aggregateId);

}
