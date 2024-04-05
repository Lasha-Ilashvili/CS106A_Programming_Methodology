package Seminar;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class problem38 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem38().start();
  }

  public void run() {
    println("Your budget is 1000$, dont waste it <33");
    while (budget > 0) {
      int roulete = rgen.nextInt(37);

      int guess = readInt("Enter your guess: ");
      int bet = readInt("Enter your bet: ");

      println("number is: " + roulete);
      winLose(guess, roulete, bet);
      println(budget + "$ are remaining");
    }
  }

  private void winLose(int guess, int roulete, int bet) {
    if (guess == roulete) {
      println("You won");
      budget += bet;
    } else {
      budget -= bet;
      println("You lose");
    }
  }

  private int budget = 1000;
  private RandomGenerator rgen = RandomGenerator.getInstance();
}
