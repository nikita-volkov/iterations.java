package com.github.nikita_volkov.java.iterations;

import java.util.function.Function;

public final class MapIteration<input, output1, output2> implements Iteration<input, output2> {

  private final Iteration<input, output1> initialFold;
  private final Function<output1, output2> fn;

  public MapIteration(Iteration<input, output1> initialFold, Function<output1, output2> fn) {
    this.initialFold = initialFold;
    this.fn = fn;
  }

  @Override
  public void init() {
    initialFold.init();
  }

  @Override
  public boolean step(input input) {
    return initialFold.step(input);
  }

  @Override
  public output2 output() {
    return fn.apply(initialFold.output());
  }

}
