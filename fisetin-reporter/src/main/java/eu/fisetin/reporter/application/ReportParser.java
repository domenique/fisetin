package eu.fisetin.reporter.application;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.tripled.fisetin.model.Feature;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReportParser {

  private final JsonParser jsonParser;

  public ReportParser(String absolutePath) throws IOException {
    // needs a file so that the input stream is closed properly.
    jsonParser = new ObjectMapper().getFactory().createParser(Paths.get(absolutePath).toFile());
  }

  public List<Feature> parse() throws IOException {
    List<Feature> returnedFeatures = new ArrayList<>();
    jsonParser.nextToken();

    if (JsonToken.START_ARRAY.equals(jsonParser.getCurrentToken())) {
      while (jsonParser.getCurrentToken() != null && !JsonToken.END_ARRAY.equals(jsonParser.getCurrentToken())) {
        FeatureParser.forParser(jsonParser)
                     .parse()
                     .ifPresent(returnedFeatures::add);
      }
    }

    jsonParser.close();
    return returnedFeatures;
  }
}
