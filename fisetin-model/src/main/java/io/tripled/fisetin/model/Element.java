package io.tripled.fisetin.model;

import java.util.List;

public class Element {

  private String id;
  private String name;
  private String type;
  private String description;
  private String keyword;
  private int line;
  private List<Step> steps;
  private List<Hook> before;
  private List<Hook> after;
  private List<Tag>tags;

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

  public List<Step> getSteps() {
    return steps;
  }

  public List<Hook> getBefore() {
    return before;
  }

  public List<Hook> getAfter() {
    return after;
  }

  public List<Tag> getTags() {
    return tags;
  }
}
