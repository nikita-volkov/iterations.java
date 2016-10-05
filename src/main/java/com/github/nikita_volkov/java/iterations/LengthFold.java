package com.github.nikita_volkov.java.iterations;

public final class LengthFold<input> implements Fold<input, Long, Long> {

  @Override
  public Long step(Long accumulator, input input) {
    return accumulator + 1;
  }

  @Override
  public Long init() {
    return 0L;
  }

  @Override
  public Long extract(Long accumulator) {
    return accumulator;
  }

}
