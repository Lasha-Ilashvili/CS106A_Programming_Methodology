package Seminar;

import java.util.ArrayList;
import java.util.Arrays;

import acm.program.ConsoleProgram;

public class check extends ConsoleProgram {
  public static void main(String[] args) {
    new check().start();
  }

  public void run() {
    int[] arr = { 24, 52, 75, 1, 6, 73, 1, 75 };
    println(big(arr));
  }

  private String big(int[] numbers) {
    Arrays.sort(numbers);
    ArrayList<Integer> oneNum = new ArrayList<>(); // only numbers through 1 to 9(inclusive)
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] / 10 == 0)
        oneNum.add(numbers[i]);
    }
    String result = "";
    for (int i = oneNum.size() - 1; i >= 0; i--) {
      for (int j = numbers.length - 1; j >= 0; j--) {
        if (numbers[j] / 10 != 0) {
          if (oneNum.get(i) * 10 >= numbers[j] && result.indexOf(oneNum.get(i)) == -1) {
            result += oneNum.get(i);
          } else {
            result += numbers[j];
          }
          if (i == 0 && oneNum.get(i) >= numbers[j]) {
            for (int k = j; k >= 0; k--) {
              if (numbers[k] / 10 != 0) {
                result += numbers[k]; // in case one digit num is more than two digits(for example 3>30 so we add 30
                // and rest of the numbers to String)
              }
            }
          }
        }
      }
    }
    return result;
  }
}
