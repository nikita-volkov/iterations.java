package com.github.nikita_volkov.java.iterations;

public final class ZipIteration<input, output1, output2> implements Iteration<input, ZipIteration.Pair<output1, output2>> {

  private final Iteration<input, output1> iteration1;
  private final Iteration<input, output2> iteration2;

  private boolean iteration1Active;
  private boolean iteration2Active;

  public ZipIteration(Iteration<input, output1> iteration1, Iteration<input, output2> iteration2) {
    this.iteration1 = iteration1;
    this.iteration2 = iteration2;
  }

  @Override
  public void init() {
    iteration1.init();
    iteration2.init();
    iteration1Active = true;
    iteration2Active = true;
  }

  @Override
  public boolean step(input input) {
    if (iteration1Active) {
      iteration1Active = iteration1.step(input);
    }
    if (iteration2Active) {
      iteration2Active = iteration2.step(input);
    }
    return iteration1Active || iteration2Active;
  }

  @Override
  public Pair<output1, output2> output() {
    return new Pair<>(iteration1.output(), iteration2.output());
  }

  public final static class Pair<_1, _2> {
    public final _1 _1;
    public final _2 _2;

    public Pair(_1 _1, _2 _2) {
      this._1 = _1;
      this._2 = _2;
    }
  }

}
