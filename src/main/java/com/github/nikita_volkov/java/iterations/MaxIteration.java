package com.github.nikita_volkov.java.iterations;

import java.util.Optional;

public final class MaxIteration<input extends Comparable<input>> implements Iteration<input, Optional<input>> {

  private Optional<input> state;

  @Override
  public void init() {
    state = Optional.empty();
  }

  @Override
  public boolean step(input input) {
    if (!state.isPresent() || input.compareTo(state.get()) >= 0) {
      state = Optional.of(input);
    }
    return true;
  }

  @Override
  public Optional<input> output() {
    Optional<input> output = state;
    state = null;
    return output;
  }

}
