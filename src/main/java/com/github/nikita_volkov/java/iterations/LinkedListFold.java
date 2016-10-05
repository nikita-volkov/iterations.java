package com.github.nikita_volkov.java.iterations;

import java.util.*;

public final class LinkedListFold<element> implements Fold<element, LinkedList<element>, LinkedList<element>> {
  @Override
  public LinkedList<element> init() {
    return new LinkedList<element>();
  }

  @Override
  public LinkedList<element> step(LinkedList<element> accumulator, element input) {
    accumulator.add(input);
    return accumulator;
  }

  @Override
  public LinkedList<element> extract(LinkedList<element> accumulator) {
    return accumulator;
  }
}
