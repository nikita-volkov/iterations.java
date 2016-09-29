package com.github.nikita_volkov.java.iterations.fold;

import java.util.Iterator;

/**
 * Something that can consume an iterator producing some output.
 */
public interface Iteration<input, output> {

  output consume(Iterator<input> iterator);

}
