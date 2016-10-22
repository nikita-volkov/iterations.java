package com.github.nikita_volkov.java.iterations;

import java.util.Optional;

public final class MaxIteration<input extends Comparable<input>> implements Iteration<input, Optional<input>> {

  private input state;

  @Override
  public boolean step(input input) {
    if (state == null || input.compareTo(state) >= 0) {
      state = input;
    }
    return true;
  }

  @Override
  public Optional<input> output() {
    return Optional.ofNullable(state);
  }

}
