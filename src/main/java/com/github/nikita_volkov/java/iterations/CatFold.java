package com.github.nikita_volkov.java.iterations;

public final class CatFold implements Fold<Character, StringBuilder, String> {

  @Override
  public StringBuilder init() {
    return new StringBuilder();
  }

  @Override
  public StringBuilder step(StringBuilder stringBuilder, Character character) {
    stringBuilder.append(character);
    return stringBuilder;
  }

  @Override
  public String extract(StringBuilder stringBuilder) {
    return stringBuilder.toString();
  }

}
