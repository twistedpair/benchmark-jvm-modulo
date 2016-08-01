package com.lustforge.modulo

import org.scalameter.api._
import org.scalameter.picklers.Implicits._
import org.scalameter.persistence.GZIPJSONSerializationPersistor

object RangeBenchmark extends Bench[Double] {

  /* configuration */

  lazy val executor = LocalExecutor(new Executor.Warmer.Default,Aggregator.median[Double],measurer)
    
  lazy val measurer = new Measurer.IgnoringGC() //.withNanos()
  lazy val reporter = new LoggingReporter[Double] // DsvReporter[Double](',') //new LoggingReporter[Double]
  lazy val persistor = GZIPJSONSerializationPersistor(new java.io.File("out.json"))

  /* inputs */

  val divisor = 8^10
  val size = 20
  val repsPerRun = 1000//*1000 // 1000*1000*100 // 0*1000*1000
  val dividends = Gen.range("dividend")(Int.MaxValue-size, Int.MaxValue, 1)
  
  def doBunch(v:Int):Unit = {
    var i = 0
    while(i < repsPerRun) {
        v % divisor
        i += 1
    }
  }
  
  def doBunchDouble(v:Double):Unit = {
    var i = 0
    val divDouble = divisor.toDouble
    while(i < repsPerRun) {
        v % divDouble
        i += 1
    }
  }

  def doBunchAnd(v:Int):Unit = {
    val d = (divisor-1)
    var i = 0
    while(i < repsPerRun) {
        v & d
        i += 1
    }
  }
  
  performance of "modulo" in {
    measure method "modulo_int" in {
      using(dividends) curve("Range") in doBunch
    }
 
    measure method "modulo_double" in {
      using(dividends) in { v => doBunchDouble(v.toDouble) }
    }

    measure method "modulo_conjunction" in {
      using(dividends) in doBunchAnd
    }
  }

}