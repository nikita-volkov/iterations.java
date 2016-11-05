package com.github.nikita_volkov.java.iterations.executor;

import com.github.nikita_volkov.java.iterables.ArrayIterable;
import com.github.nikita_volkov.java.iterations.Iteration;

/**
 * Turn any Iterable into IterationExecutor.
 */
public final class ArrayIterationExecutor<input> implements IterationExecutor<input> {

  private final IterableIterationExecutor<input> iterationExecutor;

  public ArrayIterationExecutor(input... inputs) {
    iterationExecutor = new IterableIterationExecutor<>(new ArrayIterable<>(inputs));
  }

  @Override
  public <output> output execute(Iteration<input, output> iteration) {
    return iterationExecutor.execute(iteration);
  }

}
