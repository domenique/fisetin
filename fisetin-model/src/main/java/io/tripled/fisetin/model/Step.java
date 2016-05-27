package io.tripled.fisetin.model;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class Step {

  private String name;
  private  String keyword;
  private String line;
  private Result result;
  private List<Row> rows;
  private Match match = null;
  private List<Embedding> embeddings;
  private List<Integer> matchedColumns;
  private JsonNode[] output;
  private DocString doc_string;

  public String getName() {
    return name;
  }

  public String getKeyword() {
    return keyword;
  }

  public String getLine() {
    return line;
  }

  public Result getResult() {
    return result;
  }

  public List<Row> getRows() {
    return rows;
  }

  public Match getMatch() {
    return match;
  }

  public List<Embedding> getEmbeddings() {
    return embeddings;
  }

  public List<Integer> getMatchedColumns() {
    return matchedColumns;
  }

  public JsonNode[] getOutput() {
    return output;
  }

  public DocString getDoc_string() {
    return doc_string;
  }
}
