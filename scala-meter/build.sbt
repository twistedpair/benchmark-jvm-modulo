name := "modulo-benchmark"

version := "1.0.0-alpha"

scalaVersion := "2.11.8"

// don't waste space/time compiling Docs
sources in doc in Compile := List() 

libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.5" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.7"

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

parallelExecution in Test := false


// The local maven repository
resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

// Enable resolution graph caching for compile speedup
updateOptions := updateOptions.value.withCachedResolution(true)
