package io.tripled.fisetin.feature.dto;

import java.util.List;

public class ElementDto {

  private String id;
  private String name;
  private String type;
  private String description;
  private String keyword;
  private int line;
  private List<StepDto> steps;
  private List<HookDto> before;
  private List<HookDto> after;
  private List<TagDto>tags;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public String getKeyword() {
    return keyword;
  }

  public int getLine() {
    return line;
  }

  public List<StepDto> getSteps() {
    return steps;
  }

  public List<HookDto> getBefore() {
    return before;
  }

  public List<HookDto> getAfter() {
    return after;
  }

  public List<TagDto> getTags() {
    return tags;
  }
}
