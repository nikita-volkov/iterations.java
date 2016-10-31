package com.github.nikita_volkov.java.iterations.executor;

import com.github.nikita_volkov.java.iterations.Iteration;

/**
 * Turn any Iterable into IterationExecutor.
 */
public final class IterableIterationExecutor<input> implements IterationExecutor<input> {

  private final Iterable<input> iterable;

  public IterableIterationExecutor(Iterable<input> iterable) {
    this.iterable = iterable;
  }

  @Override
  public <output> output execute(Iteration<input, output> iteration) {
    for (input input : iterable) {
      if (!iteration.step(input)) break;
    }
    return iteration.output();
  }

}
