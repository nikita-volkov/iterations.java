package com.github.nikita_volkov.java.iterations;

import java.util.LinkedList;

public final class LinkedListIteration<input> implements Iteration<input, LinkedList<input>> {

  private LinkedList<input> state;

  @Override
  public void init() {
    state = new LinkedList<input>();
  }

  @Override
  public boolean step(input input) {
    state.add(input);
    return true;
  }

  @Override
  public LinkedList<input> output() {
    LinkedList<input> output = state;
    state = null;
    return output;
  }

}
