package com.github.nikita_volkov.java.iterations;

import java.util.function.Function;

public final class MapFold<input, accumulator, output1, output2> implements Fold<input, accumulator, output2> {

  private final Fold<input, accumulator, output1> initialFold;
  private final Function<output1, output2> projection;

  public MapFold(Fold<input, accumulator, output1> initialFold, Function<output1, output2> projection) {
    this.initialFold = initialFold;
    this.projection = projection;
  }

  @Override
  public accumulator init() {
    return initialFold.init();
  }

  @Override
  public accumulator step(accumulator accumulator, input input) {
    return initialFold.step(accumulator, input);
  }

  @Override
  public output2 extract(accumulator accumulator) {
    return projection.apply(initialFold.extract(accumulator));
  }

}
