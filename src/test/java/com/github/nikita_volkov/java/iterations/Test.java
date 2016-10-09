package com.github.nikita_volkov.java.iterations;

import junit.framework.TestCase;

import java.util.Arrays;

public class Test extends TestCase {

  public void testMapIteration() {

    Iteration<String, String> iteration =
      new MapIteration<>(
        new CatIteration(),
        string -> string + "!"
      );

    assertEquals("abc!", iteration.consume(Arrays.asList("a", "b", "c").iterator()));

  }

  public void testZipIteration() {

    Iteration<String, String> iteration =
      new MapIteration<>(
        new ZipIteration<>(
          new LengthIteration<>(),
          new CatIteration()
        ),
        r -> r._2 + "(" + r._1.toString() + ")"
      );

    assertEquals("abc(3)", iteration.consume(Arrays.asList("a", "b", "c").iterator()));

  }

  public void testUniqueIteration() {

    Iteration<String, String> iteration =
      new UniqueIteration<>(new CatIteration());

    assertEquals("abc", iteration.consume(Arrays.asList("a", "b", "b", "c").iterator()));

  }

  public void testContraflatmapIteration() {

    Iteration<Integer, String> iteration =
      new ContraflatmapIteration<>(new CatIteration(), i -> i % 2 == 0 ? Arrays.asList(i.toString()) : Arrays.asList());

    assertEquals("24", iteration.consume(Arrays.asList(1, 2, 3, 4, 5)));

  }

}