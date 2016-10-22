package com.github.nikita_volkov.java.iterations;

import java.util.*;

/**
 * Modifies an existing iteration to operate only on unique input values.
 */
public final class UniquifyingIteration<input, output> implements Iteration<input, output> {

  private final Iteration<input, output> initialIteration;

  private Set<input> state;

  public UniquifyingIteration(Iteration<input, output> initialIteration) {
    this.initialIteration = initialIteration;
    state = new HashSet<>();
  }

  @Override
  public boolean step(input input) {
    if (!state.contains(input)) {
      state.add(input);
      return initialIteration.step(input);
    }
    return true;
  }

  @Override
  public output output() {
    return initialIteration.output();
  }

}
