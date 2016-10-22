package com.github.nikita_volkov.java.iterations;

import com.github.nikita_volkov.java.iterables.ArrayIterable;

import java.util.LinkedList;

public final class ZippingManyIteration<input, output> implements Iteration<input, Iterable<output>> {

  private final Iterable<Iteration<input, output>> iterations;

  public ZippingManyIteration(Iterable<Iteration<input, output>> iterations) {
    this.iterations = iterations;
  }

  public ZippingManyIteration(Iteration<input, output>... iterations) {
    this(new ArrayIterable<>(iterations));
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
