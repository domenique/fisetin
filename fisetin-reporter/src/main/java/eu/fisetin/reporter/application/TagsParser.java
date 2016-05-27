package eu.fisetin.reporter.application;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import io.tripled.fisetin.model.Tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TagsParser implements Parser<List<Tag>> {

  private final JsonParser jsonParser;

  public static Parser forParser(JsonParser jsonParser) {
    return new TagsParser(jsonParser);
  }

  public TagsParser(JsonParser jsonParser) {
    this.jsonParser = jsonParser;
  }

  @Override
  public List<Tag> parse() throws IOException {
    List<Tag> parsedTags = new ArrayList<>();
    // we are at the fieldName
    jsonParser.nextToken();
    jsonParser.nextToken();
    if (JsonToken.START_OBJECT.equals(jsonParser.getCurrentToken())) {
      jsonParser.readValuesAs(Tag.class).forEachRemaining(parsedTags::add);
    }
    return parsedTags;
  }

  @Override
  public boolean supports(Class<?> type) {
    return Tag.class.isAssignableFrom(type);
  }
}
