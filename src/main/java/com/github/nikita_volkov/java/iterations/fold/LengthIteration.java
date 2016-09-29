package com.github.nikita_volkov.java.iterations.fold;

import java.util.Iterator;

public final class LengthIteration<input> implements Iteration<input, Long> {
  @Override
  public Long consume(Iterator<input> iterator) {
    long length = 0;
    while (iterator.hasNext()) {
      length++;
      iterator.next();
    }
    return length;
  }
}
