package com.github.nikita_volkov.java.iterations;

import com.github.nikita_volkov.java.iterations.executor.*;

public final class ChainingIteration<a, b, c> implements Iteration<a, c> {

  private final Iteration<a, Iterable<b>> iteration1;
  private final Iteration<b, c> iteration2;

  public ChainingIteration(Iteration<a, Iterable<b>> iteration1, Iteration<b, c> iteration2) {
    this.iteration1 = iteration1;
    this.iteration2 = iteration2;
  }

  @Override
  public boolean step(a a) {
    return iteration1.step(a);
  }

  @Override
  public c output() {
    return new IterableIterationExecutor<>(iteration1.output()).execute(iteration2);
  }
}
