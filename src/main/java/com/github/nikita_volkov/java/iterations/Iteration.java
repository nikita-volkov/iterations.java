package com.github.nikita_volkov.java.iterations;

/**
 * A stateful one-off consumer of an iterator.
 * Supposed to be reinstantiated each time it is to be consumed.
 */
public interface Iteration<input, output> {

  boolean step(input input);

  output output();

}
