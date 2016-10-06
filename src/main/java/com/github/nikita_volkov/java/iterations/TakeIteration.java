package com.github.nikita_volkov.java.iterations;

public final class TakeIteration<input, output> implements Iteration<input, output> {

  private final Iteration<input, output> initialFold;
  private final long amount;

  private long state;

  public TakeIteration(Iteration<input, output> initialFold, long amount) {
    this.initialFold = initialFold;
    this.amount = amount;
  }

  @Override
  public void init() {
    state = amount;
  }

  @Override
  public boolean step(input input) {
    return state-- > 0 && initialFold.step(input);
  }

  @Override
  public output output() {
    return initialFold.output();
  }

}
