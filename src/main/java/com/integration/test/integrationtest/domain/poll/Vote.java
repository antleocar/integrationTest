package com.integration.test.integrationtest.domain.poll;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Vote {

  @Id
  private String idVote;
  private String idPoll;
  private String pollOption;

}
