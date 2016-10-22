package com.github.nikita_volkov.java.iterations;

import java.util.function.Function;

public final class ContramappingIteration<input1, input2, output> implements Iteration<input2, output> {

  private final Iteration<input1, output> initialIteration;
  private final Function<input2, input1> fn;

  public ContramappingIteration(Iteration<input1, output> initialIteration, Function<input2, input1> fn) {
    this.initialIteration = initialIteration;
    this.fn = fn;
  }

  @Override
  public void init() {
    initialIteration.init();
  }

  @Override
  public boolean step(input2 input2) {
    return initialIteration.step(fn.apply(input2));
  }

  @Override
  public output output() {
    return initialIteration.output();
  }

}
