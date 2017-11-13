package com.integration.test.integrationtest.service.poll.command;

import java.util.List;
import lombok.Data;

@Data
public class PollCommand {

  private final String idPoll;
  private final List<String> idVotes;

}
