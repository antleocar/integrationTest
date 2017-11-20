package com.integration.test.integrationtest.service.vote.projection;

public class VoteProjection {

  private String voteId;
  private String pollId;
  private int version;

  public String getVoteId() {
    return voteId;
  }

  public void setVoteId(String voteId) {
    this.voteId = voteId;
  }

  public String getPollId() {
    return pollId;
  }

  public void setPollId(String pollId) {
    this.pollId = pollId;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }
}
