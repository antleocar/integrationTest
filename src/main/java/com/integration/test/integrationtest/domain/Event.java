package com.integration.test.integrationtest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Event {

  private String aggregateId;
  private Long creationMoment;
  private int version;

}
