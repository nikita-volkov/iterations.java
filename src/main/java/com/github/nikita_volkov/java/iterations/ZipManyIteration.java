package com.github.nikita_volkov.java.iterations;

import com.github.nikita_volkov.java.iterables.ArrayIterable;

import java.util.LinkedList;

public final class ZipManyIteration<input, output> implements Iteration<input, Iterable<output>> {

  private final Iterable<Iteration<input, output>> iterations;

  public ZipManyIteration(Iterable<Iteration<input, output>> iterations) {
    this.iterations = iterations;
  }

  public ZipManyIteration(Iteration<input, output>... iterations) {
    this(new ArrayIterable<>(iterations));
  }

  @Override
  public void init() {
    for (Iteration<input, output> iteration : iterations) {
      iteration.init();
    }
  }

  @Override
  public boolean step(input input) {
    boolean result = false;
    for (Iteration<input, output> iteration : iterations) {
      result = iteration.step(input) || result;
    }
    return result;
  }

  @Override
  public Iterable<output> output() {
    LinkedList<output> outputs = new LinkedList<>();
    for (Iteration<input, output> iteration : iterations) {
      outputs.add(iteration.output());
    }
    return outputs;
  }

}
