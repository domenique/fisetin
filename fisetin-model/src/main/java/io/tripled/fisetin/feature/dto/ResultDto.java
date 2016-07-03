package io.tripled.fisetin.feature.dto;


public class ResultDto {

  private String status;
  private String error_message;
  private Long duration;

  public String getStatus() {
    return status;
  }

  public String getError_message() {
    return error_message;
  }

  public Long getDuration() {
    return duration;
  }
}
