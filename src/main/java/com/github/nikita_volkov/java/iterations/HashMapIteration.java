package com.github.nikita_volkov.java.iterations;

import com.github.nikita_volkov.java.composites.Product2;

import java.util.HashMap;

public final class HashMapIteration<key, value> implements Iteration<Product2<key, value>, HashMap<key, value>> {

  private HashMap<key, value> state = new HashMap<>();

  @Override
  public boolean step(Product2<key, value> input) {
    state.put(input._1, input._2);
    return true;
  }

  @Override
  public HashMap<key, value> output() {
    return state;
  }

}
