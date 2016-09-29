package com.github.nikita_volkov.java.iterations.fold;

import java.util.Iterator;
import java.util.function.Function;

public final class MapIteration<input, output1, output2> implements Iteration<input, output2> {
  private final Iteration<input, output1> initialIteration;
  private final Function<output1, output2> projection;

  public MapIteration(Iteration<input, output1> initialIteration, Function<output1, output2> projection) {
    this.initialIteration = initialIteration;
    this.projection = projection;
  }

  @Override
  public output2 consume(Iterator<input> iterator) {
    return projection.apply(initialIteration.consume(iterator));
  }
}
