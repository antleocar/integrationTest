package com.integration.test.integrationtest.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Vote {

  private String idPoll;
  private String pollOption;

}
