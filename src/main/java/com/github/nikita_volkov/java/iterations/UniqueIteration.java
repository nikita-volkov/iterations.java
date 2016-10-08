package com.github.nikita_volkov.java.iterations;

import java.util.*;

/**
 * Modifies an existing iteration to operate only on unique input values.
 */
public final class UniqueIteration<input, output> implements Iteration<input, output> {

  private final Iteration<input, output> initialIteration;

  private Set<input> state;

  public UniqueIteration(Iteration<input, output> initialIteration) {
    this.initialIteration = initialIteration;
  }

  @Override
  public void init() {
    state = new HashSet<input>();
  }

  @Override
  public boolean step(input input) {
    if (!state.contains(input)) {
      return initialIteration.step(input);
    }
    return true;
  }

  @Override
  public output output() {
    state = null;
    return initialIteration.output();
  }

}