package io.fisetin.server.feature.application;

import eu.tripledframework.eventbus.Handler;
import eu.tripledframework.eventbus.Handles;
import org.springframework.stereotype.Service;

@Service
@Handler
public class FeatureApplicationService {

  @Handles(CreateFeatureCommand.class)
  public void create(CreateFeatureCommand createFeatureCommand) {

  }
}
