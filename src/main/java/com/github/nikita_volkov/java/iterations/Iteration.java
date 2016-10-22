package com.github.nikita_volkov.java.iterations;

import java.util.Iterator;

/**
 * A stateful one-off consumer of an iterator.
 * Supposed to be recreated each time the {@link #consume(Iterator)} method is to be called.
 */
public interface Iteration<input, output> {

  boolean step(input input);

  output output();

  default output consume(Iterator<input> iterator) {
    while (iterator.hasNext()) {
      if (!step(iterator.next())) break;
    }
    return output();
  }

  default output consume(Iterable<input> iterable) {
    return consume(iterable.iterator());
  }

}
