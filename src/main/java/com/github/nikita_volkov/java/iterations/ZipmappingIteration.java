package com.github.nikita_volkov.java.iterations;

import java.util.function.BiFunction;

public final class ZipmappingIteration<input, output1, output2, output3> implements Iteration<input, output3> {

  private final Iteration<input, output1> iteration1;
  private final Iteration<input, output2> iteration2;
  private final BiFunction<output1, output2, output3> fn;

  private boolean iteration1Active;
  private boolean iteration2Active;

  public ZipmappingIteration(Iteration<input, output1> iteration1, Iteration<input, output2> iteration2, BiFunction<output1, output2, output3> fn) {
    this.iteration1 = iteration1;
    this.iteration2 = iteration2;
    this.fn = fn;
    iteration1Active = true;
    iteration2Active = true;
  }

  @Override
  public boolean step(input input) {
    if (iteration1Active) {
      iteration1Active = iteration1.step(input);
    }
    if (iteration2Active) {
      iteration2Active = iteration2.step(input);
    }
    return iteration1Active || iteration2Active;
  }

  @Override
  public output3 output() {
    return fn.apply(iteration1.output(), iteration2.output());
  }

}
