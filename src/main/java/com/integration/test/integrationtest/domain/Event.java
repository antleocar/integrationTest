package com.integration.test.integrationtest.domain;

public abstract class Event {

  private String aggregateId;
  private Long creationMoment;
  private int version;

  public Event(String aggregateId, Long creationMoment, int version) {
    this.aggregateId = aggregateId;
    this.creationMoment = creationMoment;
    this.version = version;
  }

  public String getAggregateId() {
    return aggregateId;
  }

  public void setAggregateId(String aggregateId) {
    this.aggregateId = aggregateId;
  }

  public Long getCreationMoment() {
    return creationMoment;
  }

  public void setCreationMoment(Long creationMoment) {
    this.creationMoment = creationMoment;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }
}
