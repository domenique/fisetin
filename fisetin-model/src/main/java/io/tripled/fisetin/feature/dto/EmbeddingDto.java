package io.tripled.fisetin.feature.dto;


import java.nio.charset.Charset;
import java.util.Base64;

public class EmbeddingDto {

  private String mime_type;
  private String data;

  public String getMime_type() {
    return mime_type;
  }

  public String getData() {
    return data;
  }

  public String getDecodedData() {
    return new String(Base64.getDecoder().decode(data.getBytes(Charset.forName("UTF-8"))), Charset.forName("UTF-8"));
  }
}
