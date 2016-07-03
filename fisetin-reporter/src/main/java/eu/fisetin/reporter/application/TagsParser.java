package eu.fisetin.reporter.application;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import io.tripled.fisetin.feature.dto.TagDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TagsParser implements Parser<List<TagDto>> {

  private final JsonParser jsonParser;

  public static Parser forParser(JsonParser jsonParser) {
    return new TagsParser(jsonParser);
  }

  public TagsParser(JsonParser jsonParser) {
    this.jsonParser = jsonParser;
  }

  @Override
  public List<TagDto> parse() throws IOException {
    List<TagDto> parsedTags = new ArrayList<>();
    // we are at the fieldName
    jsonParser.nextToken();
    jsonParser.nextToken();
    if (JsonToken.START_OBJECT.equals(jsonParser.getCurrentToken())) {
      jsonParser.readValuesAs(TagDto.class).forEachRemaining(parsedTags::add);
    }
    return parsedTags;
  }

  @Override
  public boolean supports(Class<?> type) {
    return TagDto.class.isAssignableFrom(type);
  }
}
