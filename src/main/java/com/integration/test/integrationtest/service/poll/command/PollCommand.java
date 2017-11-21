package com.integration.test.integrationtest.service.poll.command;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollCommand {

  private String id;
  private String idPoll;
  private List<String> pollOptions;
  private Map<String, Integer> votes;

}
