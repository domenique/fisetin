package io.tripled.fisetin.feature.dto;

public enum StatusDto {

  PASSED,
  FAILED,
  SKIPPED,
  PENDING,
  UNDEFINED,
  MISSING;

  public String getRawName() {
    return name().toLowerCase();
  }

  public String getLabel() {
    return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
  }

  public static StatusDto toStatus(String status) {
    return valueOf(status.toUpperCase());
  }

  public boolean isPassed() {
    return this == PASSED;
  }
}