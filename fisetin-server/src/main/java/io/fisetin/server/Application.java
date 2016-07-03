package io.fisetin.server;

import eu.tripledframework.eventbus.autoconfigure.EnableEventHandlerSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories
@EnableEventHandlerSupport(basePackage = "io.fisetin.server.feature.application")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
