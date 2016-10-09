package com.github.nikita_volkov.java.iterations;

import java.util.Iterator;

public interface Iteration<input, output> {

  void init();
  boolean step(input input);
  output output();

  default output consume(Iterator<input> iterator) {
    init();
    while (iterator.hasNext()) {
      if (!step(iterator.next())) break;
    }
    return output();
  }

  default output consume(Iterable<input> iterable) {
    return consume(iterable.iterator());
  }

}
