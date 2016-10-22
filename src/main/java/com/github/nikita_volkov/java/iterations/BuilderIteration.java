package com.github.nikita_volkov.java.iterations;

/**
 * A helper for iterations utilising mutable builders.
 */
public final class BuilderIteration<input, output> implements Iteration<input, output> {

  private final BuilderManager<Object, input, output> builderManager;

  private final Object builder;

  public BuilderIteration(BuilderManager<?, input, output> builderManager) {
    this.builderManager = (BuilderManager<Object, input, output>) builderManager;
    this.builder = builderManager.createBuilder();
  }

  @Override
  final public boolean step(input input) {
    builderManager.addToBuilder(builder, input);
    return true;
  }

  @Override
  final public output output() {
    return builderManager.build(builder);
  }

  public interface BuilderManager<builder, input, output> {
    builder createBuilder();
    void addToBuilder(builder builder, input input);
    output build(builder builder);
  }

}