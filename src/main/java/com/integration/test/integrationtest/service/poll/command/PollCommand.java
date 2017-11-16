package com.integration.test.integrationtest.service.poll.command;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class PollCommand {

  private UUID id;
  private final String idPoll;
  private final List<String> idVotes;

}
