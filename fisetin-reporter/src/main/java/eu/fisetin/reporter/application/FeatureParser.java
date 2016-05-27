package eu.fisetin.reporter.application;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import io.tripled.fisetin.model.Feature;
import io.tripled.fisetin.model.Feature.FeatureBuilder;

import java.io.IOException;
import java.util.Optional;

public class FeatureParser implements Parser<Optional<Feature>> {
  private FeatureBuilder featureFeatureBuilder;
  private final JsonParser jsonParser;

  public static FeatureParser forParser(JsonParser jsonParser) {
    return new FeatureParser(jsonParser);
  }

  private FeatureParser(JsonParser jsonParser) {
    this.jsonParser = jsonParser;
    this.featureFeatureBuilder = Feature.aFeature();
  }

  public Optional<Feature> parse() throws IOException {
    jsonParser.nextToken();
    if (JsonToken.START_OBJECT.equals(jsonParser.getCurrentToken())) {
      jsonParser.nextToken();
      while (!JsonToken.END_OBJECT.equals(jsonParser.getCurrentToken())) {
        String fieldName = jsonParser.getCurrentName();

        if ("id".equals(fieldName)) {
          featureFeatureBuilder.withId(jsonParser.nextTextValue());
        }

        if ("tags".equals(fieldName)) {
          featureFeatureBuilder.withTags(new TagsParser(jsonParser).parse());
        }

        if ("description".equals(fieldName)) {
          featureFeatureBuilder.withDescription(jsonParser.nextTextValue());
        }

        if ("name".equals(fieldName)) {
          featureFeatureBuilder.withName(jsonParser.nextTextValue());
        }

        if ("keyword".equals(fieldName)) {
          featureFeatureBuilder.withKeyword(jsonParser.nextTextValue());
        }

        if ("elements".equals(fieldName)) {
          featureFeatureBuilder.withElements(new ElementsParser(jsonParser).parse());
        }

        if ("uri".equals(fieldName)) {
          featureFeatureBuilder.withUri(jsonParser.nextTextValue());
        }

        jsonParser.nextToken();
      }
      return Optional.of(featureFeatureBuilder.build());
    } else {
      return Optional.empty();
    }
  }

  @Override
  public boolean supports(Class<?> type) {
    return Feature.class.isAssignableFrom(type);
  }
}
