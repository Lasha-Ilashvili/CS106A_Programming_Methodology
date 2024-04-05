package Seminar;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class problem35 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem35().start();
  }

  private static final int FLIP_NUM = 100;

  public void run() {
    double tossed = 0;
    for (int i = 0; i < FLIP_NUM; i++) {
      tossed += flips();
    }
    println("An average of " + tossed / FLIP_NUM + " tosses are needed to get heads.");
  }

  private int flips() {
    int heads = 1, sum = 0;
    while (true) {
      int flip = rgen.nextInt(2);
      sum++;
      if (flip == heads)
        break;
    }
    return sum;
  }

  private RandomGenerator rgen = RandomGenerator.getInstance();
}
