package com.github.nikita_volkov.java.iterations.fold;

import java.util.Iterator;

public interface Fold<input, accumulator, output> extends Iteration<input, output> {

  accumulator init();

  accumulator step(accumulator accumulator, input input);

  output extract(accumulator accumulator);

  @Override
  default output consume(Iterator<input> iterator) {
    accumulator accumulator = init();
    while (iterator.hasNext()) {
      accumulator = step(accumulator, iterator.next());
    }
    return extract(accumulator);
  }

}
