package com.github.nikita_volkov.java.iterations;

public final class CatIteration implements Iteration<String, String> {

  private StringBuilder state;

  @Override
  public void init() {
    state = new StringBuilder();
  }

  @Override
  public boolean step(String string) {
    state.append(string);
    return true;
  }

  @Override
  public String output() {
    String result = state.toString();
    state = null;
    return result;
  }

}
