package com.github.nikita_volkov.java.iterations;

import com.github.nikita_volkov.java.composites.Product2;
import com.github.nikita_volkov.java.iterations.executor.*;
import junit.framework.TestCase;

import java.util.Arrays;

public class Test extends TestCase {

  public void testMapIteration() {

    Iteration<String, String> iteration =
      new MappingIteration<>(
        new StringCatIteration(),
        string -> string + "!"
      );

    assertEquals("abc!", new IterableIterationExecutor<>(Arrays.asList("a", "b", "c")).execute(iteration));

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

    assertEquals("abc(3)", new IterableIterationExecutor<>(Arrays.asList("a", "b", "c")).execute(iteration));

  }

  public void testUniqueIteration() {

    Iteration<String, String> iteration =
      new UniquifyingIteration<>(new StringCatIteration());

    assertEquals("abc", new IterableIterationExecutor<>(Arrays.asList("a", "b", "b", "c")).execute(iteration));

  }

  public void testContraflatmapIteration() {

    Iteration<Integer, String> iteration =
      new ContraflatmappingIteration<>(new StringCatIteration(), i -> i % 2 == 0 ? Arrays.asList(i.toString()) : Arrays.asList());

    assertEquals("24", new IterableIterationExecutor<>(Arrays.asList(1, 2, 3, 4, 5)).execute(iteration));

  }

  public void testZipBranchesTermination() {

    Iteration<Integer, Product2<Long, Long>> iteration =
      new ZippingIteration<>(
        new TakingIteration<>(new LengthIteration<>(), 3),
        new LengthIteration<>()
      );

    assertEquals(new Product2<>(3L, 5L), new IterableIterationExecutor<>(Arrays.asList(1, 2, 3, 4, 5)).execute(iteration));

  }

  public void testTakingIteration() {

    Iteration<Character, String> iteration =
      new TakingIteration<>(new CharacterCatIteration(), 2);

    assertEquals("ab", new ArrayIterationExecutor<>('a', 'b', 'c', 'd').execute(iteration));

  }

  public void testDroppingIteration() {

    Iteration<Character, String> iteration =
      new DroppingIteration<>(new CharacterCatIteration(), 2);

    assertEquals("cd", new ArrayIterationExecutor<>('a', 'b', 'c', 'd').execute(iteration));

  }

  public void testZipMany() {

    Iteration<Long, Iterable<Long>> iteration =
      new ZippingManyIteration<>(new LongSumIteration(), new LengthIteration<>());

    assertEquals(6L, new IterableIterationExecutor<>(new ArrayIterationExecutor<>(1L, 1L, 1L).execute(iteration)).execute(new LongSumIteration()).longValue());

  }

}