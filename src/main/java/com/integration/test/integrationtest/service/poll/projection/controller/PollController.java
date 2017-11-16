package com.integration.test.integrationtest.service.poll.projection.controller;


import com.integration.test.integrationtest.service.poll.projection.repository.VoteRepository;
import com.integration.test.integrationtest.service.vote.projection.VoteProjection;
import java.util.List;
import java.util.UUID;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/poll")
public class PollController {

  @Autowired
  private VoteRepository voteRepository;

  @RequestMapping(value = "/{idPoll}/votes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<VoteProjection> getVotes(@PathParam("id") UUID idPoll) {
    List<VoteProjection> votes = voteRepository.getVotes(idPoll);
    return new ResponseEntity(votes, HttpStatus.OK);
  }

}
