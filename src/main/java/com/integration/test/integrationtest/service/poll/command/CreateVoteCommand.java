package com.integration.test.integrationtest.service.poll.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVoteCommand {

  private String idPoll;
  private String pollOption;
  private Integer vote;

}
