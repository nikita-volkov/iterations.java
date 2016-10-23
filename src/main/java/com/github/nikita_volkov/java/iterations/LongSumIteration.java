package com.github.nikita_volkov.java.iterations;

public final class LongSumIteration implements Iteration<Long, Long> {

  private long state = 0L;

  @Override
  public boolean step(Long input) {
    state += input;
    return true;
  }

  @Override
  public Long output() {
    return state;
  }

}
