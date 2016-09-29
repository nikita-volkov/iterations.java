package com.github.nikita_volkov.java.iterations.fold;

import junit.framework.TestCase;

import java.util.Arrays;

public class Test extends TestCase {

  public void test1() {

    Iteration<Character, String> iteration =
      new MapIteration<>(
        new CatFold(),
        string -> string + "!"
      );

    assertEquals("abc!", iteration.consume(Arrays.asList('a', 'b', 'c').iterator()));
  }

}