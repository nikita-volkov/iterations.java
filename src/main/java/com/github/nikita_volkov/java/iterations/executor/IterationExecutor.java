package com.github.nikita_volkov.java.iterations.executor;

import com.github.nikita_volkov.java.iterations.Iteration;

public interface IterationExecutor<input> {
  <output> output execute(Iteration<input, output> iteration);
}
