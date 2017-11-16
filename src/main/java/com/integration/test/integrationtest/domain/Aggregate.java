package com.integration.test.integrationtest.domain;

import static java.lang.String.format;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Aggregate {

  private UUID id;
  private int baseVersion;
  private List<Event> newEventsList;

  protected Aggregate(UUID uuid) {
    this(uuid, new ArrayList<>());
  }

  protected Aggregate(UUID id, List<Event> newEventsList) {
    this.id = id;
    this.newEventsList = newEventsList;
  }

  protected void applyNewEvent(Event event){
    if (event.getVersion() == getBaseVersion()) {
      throw new IllegalArgumentException("New version can't be the same");
    }
    apply(event);
    newEventsList.add(event);
  }

  protected void apply(Event event){
    try {
      Method method = this.getClass().getDeclaredMethod("apply", event.getClass());
      method.setAccessible(true);
      method.invoke(this, event);
    } catch (Exception e) {
      throw new UnsupportedOperationException(format("Doesn't apply this event type", this.getClass(), event.getClass()), e);
    }

  }

  protected int nextBaseVersion(){
    return baseVersion + newEventsList.size() + 1;
  }

}
