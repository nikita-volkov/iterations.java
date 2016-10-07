package com.github.nikita_volkov.java.iterations;

import java.util.function.Function;

public final class ContraflatmapIteration<input1, input2, output> implements Iteration<input2, output> {

  private final Iteration<input1, output> initialIteration;
  private final Function<input2, Iterable<input1>> fn;

  public ContraflatmapIteration(Iteration<input1, output> initialIteration, Function<input2, Iterable<input1>> fn) {
    this.initialIteration = initialIteration;
    this.fn = fn;
  }

  @Override
  public void init() {
    initialIteration.init();
  }

  @Override
  public boolean step(input2 input2) {
    boolean goOn = false;
    for (input1 input1 : fn.apply(input2)) {
      boolean initialGoOn = initialIteration.step(input1);
      goOn = goOn || initialGoOn;
    }
    return goOn;
  }

  @Override
  public output output() {
    return initialIteration.output();
  }

}
