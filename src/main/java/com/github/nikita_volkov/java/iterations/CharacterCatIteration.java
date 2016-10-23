package com.github.nikita_volkov.java.iterations;

public final class CharacterCatIteration implements Iteration<Character, String> {

  private final StringBuilder state = new StringBuilder();

  @Override
  public boolean step(Character input) {
    state.append(input);
    return true;
  }

  @Override
  public String output() {
    return state.toString();
  }

}
