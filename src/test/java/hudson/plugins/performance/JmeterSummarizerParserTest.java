package hudson.plugins.performance;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class JmeterSummarizerParserTest {

  @Test
  public void testParse() throws Exception {
    JmeterSummarizerParser jmeterSummarizerParser = new JmeterSummarizerParser(null, null);
    File summaryLogFile = new File(getClass().getResource("/summary.log").toURI());
    PerformanceReport performanceReport = jmeterSummarizerParser.parse(summaryLogFile);

    assertEquals(1257, performanceReport.getSummarizerSize());
    assertEquals(333, performanceReport.getSummarizerAvg());
    assertEquals(3, performanceReport.getSummarizerMin());
    assertEquals(5630, performanceReport.getSummarizerMax());
    assertEquals("4.56", performanceReport.getSummarizerErrors());

    // original average is 300 ms, which results in 3 RPS
    // changing resolution to nanoseconds results in 3 000 000 RPS
    ThroughputReport throughputReport = new ThroughputReport(performanceReport);
    assertEquals(3003003.0, throughputReport.get(), 0.1);
  }
}
