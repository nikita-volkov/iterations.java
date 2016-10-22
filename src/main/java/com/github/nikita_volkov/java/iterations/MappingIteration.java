package com.github.nikita_volkov.java.iterations;

import java.util.function.Function;

public final class MappingIteration<input, output1, output2> implements Iteration<input, output2> {

  private final Iteration<input, output1> initialIteration;
  private final Function<output1, output2> fn;

  public MappingIteration(Iteration<input, output1> initialIteration, Function<output1, output2> fn) {
    this.initialIteration = initialIteration;
    this.fn = fn;
  }

  @Override
  public boolean step(input input) {
    return initialIteration.step(input);
  }

  @Override
  public output2 output() {
    return fn.apply(initialIteration.output());
  }

}
