package com.github.nikita_volkov.java.iterations;

public final class CatIteration implements Iteration<String, String> {

  private final StringBuilder state = new StringBuilder();

  @Override
  public boolean step(String string) {
    state.append(string);
    return true;
  }

  @Override
  public String output() {
    return state.toString();
  }

}
