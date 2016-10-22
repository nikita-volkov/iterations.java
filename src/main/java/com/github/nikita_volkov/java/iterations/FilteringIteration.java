package com.github.nikita_volkov.java.iterations;

import java.util.function.Predicate;

public final class FilteringIteration<input, output> implements Iteration<input, output> {

  private final Iteration<input, output> initialIteration;
  private final Predicate<input> predicate;

  public FilteringIteration(Iteration<input, output> initialIteration, Predicate<input> predicate) {
    this.initialIteration = initialIteration;
    this.predicate = predicate;
  }

  @Override
  public void init() {
    initialIteration.init();
  }

  @Override
  public boolean step(input input) {
    if (predicate.test(input)) {
      return initialIteration.step(input);
    } else {
      return true;
    }
  }

  @Override
  public output output() {
    return initialIteration.output();
  }

}
