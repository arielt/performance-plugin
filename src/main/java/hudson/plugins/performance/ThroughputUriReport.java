package hudson.plugins.performance;

/**
 * @author Artem Stasiuk (artem.stasuk@gmail.com)
 */
public class ThroughputUriReport {

  // 1000 if report times are in milliseconds
  // 1000 000 000 if report times are in nanoseconds
  private static final int RESOLUTION = 1000000000;

  private final UriReport uriReport;

  public ThroughputUriReport(final UriReport uriReport) {
    this.uriReport = uriReport;
  }

  public double get() {
    if (uriReport.size() == 0) {
      return 0;
    }

    long end = uriReport.getEnd().getTime();
    long start = uriReport.getStart().getTime();
    final long duration = end - start;

    // duration is average latency of one request
    if (duration == 0) {
      return uriReport.size(); // more than zero requests should always take at least some time. If that didn't get logged, this is the most suitable alternative.
    }
    return (((double)uriReport.size() * RESOLUTION) / ((double)duration));
  }
}
