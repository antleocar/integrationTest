package com.integration.test.integrationtest.domain.poll;

import com.integration.test.integrationtest.domain.Aggregate;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Poll extends Aggregate {

  @Id
  private String idPoll;
  private List<String> idVotes;

  public Poll(UUID id, String idPoll, List<String> idVotes) {

  }

}
