package Exam;

import acm.program.ConsoleProgram;

public class asteroidDestroy extends ConsoleProgram {
  public static void main(String[] args) {
    new asteroidDestroy().start();
  }

  public void run() {
    int planet_mass = 5;
    int[] asteroids = { 9, 9, 23, 3 };
    println(asteroidsDestroyed(asteroids, planet_mass));
  }

  private boolean asteroidsDestroyed(int[] asteroids, int planet_mass) {
    int size = asteroids.length;
    for (int i = 0; i < size; i++) {
      int num = asteroids[i];
      if (planet_mass < num) {
        for (int j = size - 1; j >= i; j--) {
          if (j == i)
            return false;
          int temp = num;
          num = asteroids[j];
          asteroids[j] = temp;

          if (planet_mass >= num)
            break;
        }
      }
      planet_mass += num;
    }
    return true;
  }
}