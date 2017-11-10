package com.integration.test.integrationtest.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.integration.test.integrationtest.repository")
public class MongoDBConfiguration extends AbstractMongoConfiguration {

  @Value("${spring.data.mongodb.host}")
  private String host;

  @Value("${spring.data.mongodb.database}")
  private String database;

  @Value("${spring.data.mongodb.port}")
  private Integer port;

  @Override
  protected String getDatabaseName() {
    return database;
  }

  @Override
  public Mongo mongo() throws Exception {
    return new MongoClient(host, port);
  }
}
