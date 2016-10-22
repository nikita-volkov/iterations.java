package com.github.nikita_volkov.java.iterations;

import java.util.function.Function;

public final class ContraflatmappingIteration<input1, input2, output> implements Iteration<input2, output> {

  private final Iteration<input1, output> initialIteration;
  private final Function<input2, Iterable<input1>> fn;

  public ContraflatmappingIteration(Iteration<input1, output> initialIteration, Function<input2, Iterable<input1>> fn) {
    this.initialIteration = initialIteration;
    this.fn = fn;
  }

  @Override
  public boolean step(input2 input2) {
    for (input1 input1 : fn.apply(input2)) {
      boolean goOn = initialIteration.step(input1);
      if (!goOn) {
        return false;
      }
    }
    return true;
  }

  @Override
  public output output() {
    return initialIteration.output();
  }

}
