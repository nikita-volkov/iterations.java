package com.github.nikita_volkov.java.iterations;

public final class DroppingIteration<input, output> implements Iteration<input, output> {

  private final Iteration<input, output> initialIteration;
  private long state;

  public DroppingIteration(Iteration<input, output> initialIteration, long amount) {
    this.initialIteration = initialIteration;
    this.state = amount;
  }

  @Override
  public boolean step(input input) {
    return state-- > 0 || initialIteration.step(input);
  }

  @Override
  public output output() {
    return initialIteration.output();
  }

}
