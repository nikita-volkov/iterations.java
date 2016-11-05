package com.github.nikita_volkov.java.iterations;

public final class TakingIteration<input, output> implements Iteration<input, output> {

  private final Iteration<input, output> initialIteration;

  private long stepsLeft;

  public TakingIteration(Iteration<input, output> initialIteration, long amount) {
    this.initialIteration = initialIteration;
    this.stepsLeft = amount;
  }

  @Override
  public boolean step(input input) {
    if (stepsLeft > 0) {
      stepsLeft--;
      return initialIteration.step(input) && stepsLeft > 0;
    } else {
      return false;
    }
  }

  @Override
  public output output() {
    return initialIteration.output();
  }

}
