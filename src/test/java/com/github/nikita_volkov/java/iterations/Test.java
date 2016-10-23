package com.github.nikita_volkov.java.iterations;

import com.github.nikita_volkov.java.composites.*;
import junit.framework.TestCase;

import java.util.Arrays;

public class Test extends TestCase {

  public void testMapIteration() {

    Iteration<String, String> iteration =
      new MappingIteration<>(
        new StringCatIteration(),
        string -> string + "!"
      );

    assertEquals("abc!", iteration.consume(Arrays.asList("a", "b", "c").iterator()));

  }

  public void testZipIteration() {

    Iteration<String, String> iteration =
      new MappingIteration<>(
        new ZippingIteration<>(
          new LengthIteration<>(),
          new StringCatIteration()
        ),
        r -> r._2 + "(" + r._1.toString() + ")"
      );

    assertEquals("abc(3)", iteration.consume(Arrays.asList("a", "b", "c").iterator()));

  }

  public void testUniqueIteration() {

    Iteration<String, String> iteration =
      new UniquifyingIteration<>(new StringCatIteration());

    assertEquals("abc", iteration.consume(Arrays.asList("a", "b", "b", "c").iterator()));

  }

  public void testContraflatmapIteration() {

    Iteration<Integer, String> iteration =
      new ContraflatmappingIteration<>(new StringCatIteration(), i -> i % 2 == 0 ? Arrays.asList(i.toString()) : Arrays.asList());

    assertEquals("24", iteration.consume(Arrays.asList(1, 2, 3, 4, 5)));

  }

  public void testZipBranchesTermination() {

    Iteration<Integer, Product2<Long, Long>> iteration =
      new ZippingIteration<>(
        new TakingIteration<>(new LengthIteration<>(), 3),
        new LengthIteration<>()
      );

    assertEquals(new Product2<>(3L, 5L), iteration.consume(Arrays.asList(1, 2, 3, 4, 5)));

  }

}