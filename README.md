# branchmark-jvm-modulo
Microbenchmarking of JVM Modulo Implementations

## Use
Set SBT to get a lot of memory, so we minimize GC overhead. Resize heap to max size on start.

```bash
SBT_OPTS="-Xms2G -Xmx2G -Xss1M"
sbt test
```
