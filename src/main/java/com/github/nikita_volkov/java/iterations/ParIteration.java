package com.github.nikita_volkov.java.iterations;

public final class ParIteration<input1, input2, output1, output2> implements Iteration<ParIteration.Pair<input1, input2>, ParIteration.Pair<output1, output2>> {

  private final Iteration<input1, output1> iteration1;
  private final Iteration<input2, output2> iteration2;

  private boolean iteration1Active;
  private boolean iteration2Active;

  public ParIteration(Iteration<input1, output1> iteration1, Iteration<input2, output2> iteration2) {
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
  public boolean step(Pair<input1, input2> input) {
    if (iteration1Active) {
      iteration1Active = iteration1.step(input._1);
    }
    if (iteration2Active) {
      iteration2Active = iteration2.step(input._2);
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
