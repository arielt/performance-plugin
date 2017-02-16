## Nanosecond performance plugin

* Fork: https://github.com/jenkinsci/performance-plugin
* Base: https://github.com/jenkinsci/performance-plugin/releases/tag/performance-2.0
* Required core: 1.580.1
* Verified with core: 1.651.3

Changes:
* ms => ns
* Requests per second => Records Per Second
* Response time => Latency

Latencies of JMeter reports expected to be in nanoseconds

Build plugin:
* mvn package
* deploy target/performance.hpi
