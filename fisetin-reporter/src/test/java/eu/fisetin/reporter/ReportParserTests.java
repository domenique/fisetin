package eu.fisetin.reporter;

import eu.fisetin.reporter.application.ReportParser;
import io.tripled.fisetin.feature.dto.FeatureDto;
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

    List<FeatureDto> features = reportParser.parse();

    assertThat(features, empty());
  }

  @Test
  public void canLoadSampleReportContainingOneFeature() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("json/sampleWithOneFeature.json"));

    List<FeatureDto> features = reportParser.parse();

    assertThat(features, hasSize(1));
    assertFirstFeature(features.get(0));
  }

  @Test
  public void canLoadSampleReportContainingTwoFeatures() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("json/sampleWithTwoFeatures.json"));

    List<FeatureDto> features = reportParser.parse();

    assertThat(features, hasSize(2));
    assertFirstFeature(features.get(0));
    assertSecondFeature(features.get(1));
  }

  @Test
  public void canHandleCells() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/cells.json"));

    reportParser.parse();
  }

  @Test
  public void canHandleDocString() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/docstring.json"));

    reportParser.parse();
  }

  @Test
  public void canHandleEmbeddedImage() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/embedded_image.json"));

    reportParser.parse();
  }

  @Test
  public void canHandleNoScenario() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/noscenario.json"));

    reportParser.parse();
  }

  @Test
  public void canHandleNoSteps() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/nosteps.json"));

    reportParser.parse();
  }

  @Test
  public void canHandleNoSteps2() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/nosteps2.json"));

    reportParser.parse();
  }

  @Test
  public void canHandleProject1() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/project1.json"));

    reportParser.parse();
  }

  @Test
  public void canHandleProject2() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/project2.json"));

    reportParser.parse();
  }

  @Test
  public void canHandleProject3() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/project3.json"));

    reportParser.parse();
  }

  @Test
  public void canHandleStatuses() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/statuses.json"));

    reportParser.parse();
  }

  @Test
  public void canHandleTags() throws IOException {
    ReportParser reportParser = new ReportParser(toAbsolutePath("cucumber/tags.json"));

    reportParser.parse();
  }

  private String toAbsolutePath(String resource) {
    try {
      return new File(ReportParserTests.class.getClassLoader().getResource(resource).toURI()).getAbsolutePath();
    } catch (URISyntaxException e) {
      throw new RuntimeException("Could not read resource: " + resource, e);
    }
  }

  private void assertFirstFeature(FeatureDto firstFeature) {
    assertThat(firstFeature.getId(), equalTo("account-holder-withdraws-cash"));
    assertThat(firstFeature.getDescription(), equalTo("This is description of the feature"));
    assertThat(firstFeature.getName(), equalTo("1st feature"));
    assertThat(firstFeature.getKeyword(), equalTo("Feature"));
    assertThat(firstFeature.getUri(), equalTo("net/masterthought/example(s)/ATM:local.feature"));
  }

  private void assertSecondFeature(FeatureDto secondFeature) {
    assertThat(secondFeature.getId(), equalTo("account-holder-withdraws-more-cash"));
    assertThat(secondFeature
        .getDescription(), equalTo("As an Account Holder\nI want to withdraw cash from an ATM,<br>so that I can get money when the bank is closed"));
    assertThat(secondFeature.getName(), equalTo("Second feature"));
    assertThat(secondFeature.getKeyword(), equalTo("Feature"));
    assertThat(secondFeature.getUri(), equalTo("net/masterthought/example/ATMK.feature"));
  }
}
