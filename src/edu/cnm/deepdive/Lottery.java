package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.Random;

public class Lottery {

  private int[] numbers;

  public Lottery(int maximum) {

    numbers = new int[maximum];

    for (int i = 0; i < numbers.length; i++) {

      numbers[i] = i + 1;

    }

  }

  private void mix(int iterations, Random rng) {
    for (int i = 0; i < iterations; i++) {
      int destination = numbers.length - i - 1;
      int source = rng.nextInt(destination + 1);
      int temp = numbers[source];
      numbers[source] = numbers[destination];
      numbers[destination] = temp;
    }
  }

  public int[] pick(int count, Random rng) {
    int[] selection;
    mix(count, rng);
    selection = Arrays
        .copyOfRange(numbers, numbers.length - count, numbers.length);
    Arrays.sort(selection);
    return selection;
  }

}
