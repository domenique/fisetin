package io.fisetin.server.feature.presentation;

import io.tripled.fisetin.feature.dto.FeatureDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController("/execution/{executionId}/feature")
@RequestMapping
public class FeatureController {

  @RequestMapping(method = RequestMethod.POST)
  public void create(@PathParam("executionId") String executionId, FeatureDto feature) {

  }

}
