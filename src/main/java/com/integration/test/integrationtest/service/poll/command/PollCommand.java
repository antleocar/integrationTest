package com.integration.test.integrationtest.service.poll.command;

import java.util.List;
import java.util.UUID;
import lombok.Data;

public class PollCommand {

  private String id;
  private String idPoll;
  private List<String> idVotes;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIdPoll() {
    return idPoll;
  }

  public void setIdPoll(String idPoll) {
    this.idPoll = idPoll;
  }

  public List<String> getIdVotes() {
    return idVotes;
  }

  public void setIdVotes(List<String> idVotes) {
    this.idVotes = idVotes;
  }
}
