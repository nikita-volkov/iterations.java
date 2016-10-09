package com.github.nikita_volkov.java.iterations;

public final class TakeIteration<input, output> implements Iteration<input, output> {

  private final Iteration<input, output> initialIteration;
  private final long amount;

  private long state;

  public TakeIteration(Iteration<input, output> initialIteration, long amount) {
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
    return state-- > 0 && initialIteration.step(input);
  }

  @Override
  public output output() {
    return initialIteration.output();
  }

}
