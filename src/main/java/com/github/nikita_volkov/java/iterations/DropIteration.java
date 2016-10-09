package com.github.nikita_volkov.java.iterations;

public final class DropIteration<input, output> implements Iteration<input, output> {

  private final Iteration<input, output> initialIteration;
  private final long amount;

  private long state;

  public DropIteration(Iteration<input, output> initialIteration, long amount) {
    this.initialIteration = initialIteration;
    this.amount = amount;
  }

  @Override
  public void init() {
    initialIteration.init();
    state = amount;
  }

  @Override
  public boolean step(input input) {
    if (state <= 0) {
      state--;
      return initialIteration.step(input);
    }
    return true;
  }

  @Override
  public output output() {
    return initialIteration.output();
  }

}