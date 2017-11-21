package com.integration.test.integrationtest.domain;

import static java.lang.String.format;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Aggregate {

  private String id;
  private int baseVersion;
  private List<Event> newEventsList;

  protected Aggregate(String uuid) {
    this(uuid, new ArrayList<>());
  }

  protected Aggregate(String id, List<Event> newEventsList) {
    this.id = id;
    this.newEventsList = newEventsList;
  }

  protected void applyNewEvent(Event event){
    if (event.getVersion() == nextBaseVersion()) {
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
