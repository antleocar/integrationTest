package com.integration.test.integrationtest.service.poll.projection.controller;


import com.integration.test.integrationtest.domain.poll.Poll;
import com.integration.test.integrationtest.service.poll.PollService;
import com.integration.test.integrationtest.service.poll.command.CreateVoteCommand;
import java.util.Optional;

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
  private PollService pollService;

  @RequestMapping(value = "/{idPoll}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Optional<Poll>> getPoll(@PathParam("id") String idPoll) {
    Optional<Poll> poll = pollService.loadPoll(idPoll);
    return new ResponseEntity<>(poll, HttpStatus.OK);
  }

  @RequestMapping(value = "/{idPoll}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> vote(@PathParam("idPoll") String idPoll, String pollOption) {
    CreateVoteCommand command = new CreateVoteCommand(idPoll, pollOption);
    pollService.process(command);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
