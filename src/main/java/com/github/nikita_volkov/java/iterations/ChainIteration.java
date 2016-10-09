package com.github.nikita_volkov.java.iterations;

public final class ChainIteration<a, b, c> implements Iteration<a, c> {

  private final Iteration<a, Iterable<b>> iteration1;
  private final Iteration<b, c> iteration2;

  public ChainIteration(Iteration<a, Iterable<b>> iteration1, Iteration<b, c> iteration2) {
    this.iteration1 = iteration1;
    this.iteration2 = iteration2;
  }

  @Override
  public void init() {
    iteration1.init();
  }

  @Override
  public boolean step(a a) {
    return iteration1.step(a);
  }

  @Override
  public c output() {
    return iteration2.consume(iteration1.output());
  }
}
