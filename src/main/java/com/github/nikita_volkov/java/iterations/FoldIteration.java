package com.github.nikita_volkov.java.iterations;

import java.util.function.*;

public final class FoldIteration<input, accumulator> implements Iteration<input, accumulator> {

  private final accumulator init;
  private final BiFunction<accumulator, input, accumulator> step;

  private accumulator state;

  public FoldIteration(accumulator init, BiFunction<accumulator, input, accumulator> step) {
    this.init = init;
    this.step = step;
  }

  @Override
  public void init() {
    state = init;
  }

  @Override
  public boolean step(input input) {
    state = step.apply(state, input);
    return true;
  }

  @Override
  public accumulator output() {
    accumulator output = state;
    state = null;
    return output;
  }

  public static <input> FoldIteration<input, input> monotonic(input init, BiFunction<input, input, input> step) {
    return new FoldIteration<>(init, step);
  }

}
