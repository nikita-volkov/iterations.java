package com.github.nikita_volkov.java.iterations;

public final class LengthIteration<input> implements Iteration<input, Long> {
  private Long state = 0L;

  @Override
  public boolean step(input o) {
    state++;
    return true;
  }

  @Override
  public Long output() {
    return state;
  }
}
