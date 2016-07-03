package io.tripled.fisetin.feature.dto;

import java.util.List;

public class FeatureDto {

  private final String id;
  private final String name;
  private final String uri;
  private final String description;
  private final String keyword;

  private final List<ElementDto> elements;
  private final List<TagDto> tags;

  public static FeatureBuilder aFeature() {
    return new FeatureBuilder();
  }

  public FeatureDto(String id, String name, String uri, String description, String keyword, List<ElementDto> elements, List<TagDto> tags) {
    this.id = id;
    this.name = name;
    this.uri = uri;
    this.description = description;
    this.keyword = keyword;
    this.elements = elements;
    this.tags = tags;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUri() {
    return uri;
  }

  public String getDescription() {
    return description;
  }

  public String getKeyword() {
    return keyword;
  }

  public List<ElementDto> getElements() {
    return elements;
  }

  public List<TagDto> getTags() {
    return tags;
  }

  public static class FeatureBuilder {
    private String id;
    private String name;
    private String uri;
    private String description;
    private String keyword;
    private List<ElementDto> elements;
    private List<TagDto> tags;

    private FeatureBuilder() {
    }


    public FeatureBuilder withId(String id) {
      this.id = id;
      return this;
    }

    public FeatureBuilder withName(String name) {
      this.name = name;
      return this;
    }

    public FeatureBuilder withUri(String uri) {
      this.uri = uri;
      return this;
    }

    public FeatureBuilder withDescription(String description) {
      this.description = description;
      return this;
    }

    public FeatureBuilder withKeyword(String keyword) {
      this.keyword = keyword;
      return this;
    }

    public FeatureBuilder withElements(List<ElementDto> elements) {
      this.elements = elements;
      return this;
    }

    public FeatureBuilder withTags(List<TagDto> tags) {
      this.tags = tags;
      return this;
    }

    public FeatureDto build() {
      return new FeatureDto(id, name, uri, description, keyword, elements, tags);
    }
  }
}
