# branchmark-jvm-modulo
Microbenchmarking of JVM Modulo Implementations

## For Scala-Meter
Set SBT to get a lot of memory, so we minimize GC overhead. Resize heap to max size on start.

```bash
cd scala-meter/
SBT_OPTS="-Xms1G -Xmx1G -Xss1M"
sbt test
```

## For JMH

```bash
cd jmh/
mvn install
java -Xmx1G -Xms1G -jar target/benchmarks.jar -wi 5 -i 1000 -f 1 -bs 1000000
```
