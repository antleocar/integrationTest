package com.integration.test.integrationtest.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public abstract class Event {

  private final UUID aggregateId;
  private final Long creationMoment;
  private final int version;

  public Event(UUID aggregateId, Long creationMoment, int version) {
    this.aggregateId = aggregateId;
    this.creationMoment = creationMoment;
    this.version = version;
  }
}
