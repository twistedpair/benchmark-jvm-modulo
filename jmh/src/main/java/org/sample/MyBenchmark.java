package org.sample;

import java.util.Random;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

    private int divisor = 8*8*8*8*8*8;

    private int dividend = (new Random()).nextInt();
    private double dividendDouble = (new Random()).nextDouble();

    @Benchmark
    public int baseline() {
        // do nothing, this is a baseline
	return 	dividend;
    }

    @Benchmark
    public int testBitwise() {
        return dividend & (divisor-1);
    }

    @Benchmark
    public int testIRem() {
       return dividend % divisor;
    }

    @Benchmark
    public double testFRem() {
       return dividendDouble % divisor;
    }
}
