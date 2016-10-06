package com.github.nikita_volkov.java.iterations;

public final class IntersperseIteration<input, output> implements Iteration<input, output> {

  private final Iteration<input, output> initialIteration;
  private final input separator;

  private boolean first;

  public IntersperseIteration(Iteration<input, output> initialIteration, input separator) {
    this.initialIteration = initialIteration;
    this.separator = separator;
  }

  @Override
  public void init() {
    initialIteration.init();
    first = true;
  }

  @Override
  public boolean step(input input) {
    if (first) {
      first = false;
      return initialIteration.step(input);
    } else {
      if (initialIteration.step(separator)) {
        return initialIteration.step(input);
      } else {
        return false;
      }
    }
  }

  @Override
  public output output() {
    return initialIteration.output();
  }

}
