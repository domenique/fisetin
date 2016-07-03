package io.tripled.fisetin.feature.dto;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class StepDto {

  private String name;
  private  String keyword;
  private String line;
  private ResultDto result;
  private List<RowDto> rows;
  private MatchDto match = null;
  private List<EmbeddingDto> embeddings;
  private List<Integer> matchedColumns;
  private JsonNode[] output;
  private DocStringDto doc_string;

  public String getName() {
    return name;
  }

  public String getKeyword() {
    return keyword;
  }

  public String getLine() {
    return line;
  }

  public ResultDto getResult() {
    return result;
  }

  public List<RowDto> getRows() {
    return rows;
  }

  public MatchDto getMatch() {
    return match;
  }

  public List<EmbeddingDto> getEmbeddings() {
    return embeddings;
  }

  public List<Integer> getMatchedColumns() {
    return matchedColumns;
  }

  public JsonNode[] getOutput() {
    return output;
  }

  public DocStringDto getDoc_string() {
    return doc_string;
  }
}
