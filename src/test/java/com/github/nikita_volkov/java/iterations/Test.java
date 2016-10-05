package com.github.nikita_volkov.java.iterations;

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

  public void test2() {

    Iteration<Character, String> iteration =
      new MapFold<>(
        new ZipFold<>(
          new LengthFold<>(),
          new CatFold()
        ),
        r -> r._2 + "(" + r._1.toString() + ")"
      );

    assertEquals("abc(3)", iteration.consume(Arrays.asList('a', 'b', 'c').iterator()));

  }

}