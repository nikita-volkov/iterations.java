package com.github.nikita_volkov.java.iterations;

/**
 * A helper for iterations utilising mutable builders.
 */
public abstract class BuilderIteration<builder, input, output> implements Iteration<input, output> {

  private builder builder;

  @Override
  final public void init() {
    builder = createBuilder();
  }

  @Override
  final public boolean step(input input) {
    addToBuilder(builder, input);
    return true;
  }

  @Override
  final public output output() {
    output output = build(builder);
    builder = null;
    return output;
  }

  protected abstract builder createBuilder();
  protected abstract void addToBuilder(builder builder, input input);
  protected abstract output build(builder builder);

}