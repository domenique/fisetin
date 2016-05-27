package eu.fisetin.reporter.application;

import java.io.IOException;

public interface Parser<T> {
  T parse() throws IOException;

  boolean supports(Class<?> type);
}
