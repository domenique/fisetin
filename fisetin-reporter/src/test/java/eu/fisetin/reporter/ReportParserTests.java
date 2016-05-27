package eu.fisetin.reporter;

import eu.fisetin.reporter.application.ReportParser;
import io.tripled.fisetin.model.Feature;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ReportParserTests {

  @Test
  public void canLoadEmptyReport() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("json/empty.json"));

    List<Feature> features = reportParser.parse();

    assertThat(features, empty());
  }

  @Test
  public void canLoadSampleReportContainingOneFeature() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("json/sampleWithOneFeature.json"));

    List<Feature> features = reportParser.parse();

    assertThat(features, hasSize(1));
    assertFirstFeature(features.get(0));
  }

  @Test
  public void canLoadSampleReportContainingTwoFeatures() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("json/sampleWithTwoFeatures.json"));

    List<Feature> features = reportParser.parse();

    assertThat(features, hasSize(2));
    assertFirstFeature(features.get(0));
    assertSecondFeature(features.get(1));
  }

  private String toAbsolutePath(String resource) {
    try {
      return new File(ReportParserTests.class.getClassLoader().getResource(resource).toURI()).getAbsolutePath();
    } catch (URISyntaxException e) {
      throw new RuntimeException("Could not read resource: " + resource, e);
    }
  }

  private void assertFirstFeature(Feature firstFeature) {
    assertThat(firstFeature.getId(), equalTo("account-holder-withdraws-cash"));
    assertThat(firstFeature.getDescription(), equalTo("This is description of the feature"));
    assertThat(firstFeature.getName(), equalTo("1st feature"));
    assertThat(firstFeature.getKeyword(), equalTo("Feature"));
    assertThat(firstFeature.getUri(), equalTo("net/masterthought/example(s)/ATM:local.feature"));
  }

  private void assertSecondFeature(Feature secondFeature) {
    assertThat(secondFeature.getId(), equalTo("account-holder-withdraws-more-cash"));
    assertThat(secondFeature
        .getDescription(), equalTo("As an Account Holder\nI want to withdraw cash from an ATM,<br>so that I can get money when the bank is closed"));
    assertThat(secondFeature.getName(), equalTo("Second feature"));
    assertThat(secondFeature.getKeyword(), equalTo("Feature"));
    assertThat(secondFeature.getUri(), equalTo("net/masterthought/example/ATMK.feature"));
  }
}
