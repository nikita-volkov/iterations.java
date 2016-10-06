package com.github.nikita_volkov.java.iterations;

import java.util.function.BiFunction;

public final class ZipMapIteration<input, output1, output2, output3> implements Iteration<input, output3> {

  private final Iteration<input, output1> iteration1;
  private final Iteration<input, output2> iteration2;
  private final BiFunction<output1, output2, output3> fn;

  public ZipMapIteration(Iteration<input, output1> iteration1, Iteration<input, output2> iteration2, BiFunction<output1, output2, output3> fn) {
    this.iteration1 = iteration1;
    this.iteration2 = iteration2;
    this.fn = fn;
  }

  @Override
  public void init() {
    iteration1.init();
    iteration2.init();
  }

  @Override
  public boolean step(input input) {
    return iteration1.step(input) && iteration2.step(input);
  }

  @Override
  public output3 output() {
    return fn.apply(iteration1.output(), iteration2.output());
  }

}
