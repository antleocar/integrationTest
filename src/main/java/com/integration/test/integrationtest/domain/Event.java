package com.integration.test.integrationtest.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Event {

  private final UUID aggregateId;
  private final Long creationMoment;
  private final int version;

}
