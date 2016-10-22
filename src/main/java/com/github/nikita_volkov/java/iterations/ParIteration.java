package com.github.nikita_volkov.java.iterations;

import com.github.nikita_volkov.java.composites.Product2;

public final class ParIteration<input1, input2, output1, output2> implements Iteration<Product2<input1, input2>, Product2<output1, output2>> {

  private final Iteration<input1, output1> iteration1;
  private final Iteration<input2, output2> iteration2;

  private boolean iteration1Active;
  private boolean iteration2Active;

  public ParIteration(Iteration<input1, output1> iteration1, Iteration<input2, output2> iteration2) {
    this.iteration1 = iteration1;
    this.iteration2 = iteration2;
    iteration1Active = true;
    iteration2Active = true;
  }

  @Override
  public boolean step(Product2<input1, input2> input) {
    if (iteration1Active) {
      iteration1Active = iteration1.step(input._1);
    }
    if (iteration2Active) {
      iteration2Active = iteration2.step(input._2);
    }
    return iteration1Active || iteration2Active;
  }

  @Override
  public Product2<output1, output2> output() {
    return new Product2<>(iteration1.output(), iteration2.output());
  }

}
