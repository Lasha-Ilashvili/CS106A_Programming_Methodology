package Seminar;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class problem37 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem37().start();
  }

  public void run() {
    int guess = readInt("Enter your guess: ");
    int roulete = rgen.nextInt(37);
    println("number is: " + roulete);
    if (guess == roulete)
      println("You won");
    else
      println("You lose");
  }

  private RandomGenerator rgen = RandomGenerator.getInstance();
}
