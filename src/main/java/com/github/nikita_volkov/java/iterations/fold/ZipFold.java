package com.github.nikita_volkov.java.iterations.fold;

public final class ZipFold<input, accumulator1, accumulator2, output1, output2>
  implements Fold<input, ZipFold.Pair<accumulator1, accumulator2>, ZipFold.Pair<output1, output2>> {

  private final Fold<input, accumulator1, output1> fold1;
  private final Fold<input, accumulator2, output2> fold2;

  public ZipFold(Fold<input, accumulator1, output1> fold1, Fold<input, accumulator2, output2> fold2) {
    this.fold1 = fold1;
    this.fold2 = fold2;
  }

  @Override
  public Pair<accumulator1, accumulator2> init() {
    return new Pair<>(fold1.init(), fold2.init());
  }

  @Override
  public Pair<accumulator1, accumulator2> step(Pair<accumulator1, accumulator2> accumulator, input input) {
    return new Pair<>(fold1.step(accumulator._1, input), fold2.step(accumulator._2, input));
  }

  @Override
  public Pair<output1, output2> extract(Pair<accumulator1, accumulator2> accumulator) {
    return new Pair<>(fold1.extract(accumulator._1), fold2.extract(accumulator._2));
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
