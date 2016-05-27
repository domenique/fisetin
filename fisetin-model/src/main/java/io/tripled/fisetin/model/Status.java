package io.tripled.fisetin.model;

public enum Status {

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

  public static Status toStatus(String status) {
    return valueOf(status.toUpperCase());
  }

  public boolean isPassed() {
    return this == PASSED;
  }
}