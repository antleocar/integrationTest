package com.integration.test.integrationtest.service.poll.command;

public class CreateVoteCommand {

  private String idPoll;
  private String pollOption;

  public CreateVoteCommand(String idPoll, String pollOption) {
    this.idPoll = idPoll;
    this.pollOption = pollOption;
  }

  public String getIdPoll() {
    return idPoll;
  }

  public void setIdPoll(String idPoll) {
    this.idPoll = idPoll;
  }

  public String getPollOption() {
    return pollOption;
  }

  public void setPollOption(String pollOption) {
    this.pollOption = pollOption;
  }
}
