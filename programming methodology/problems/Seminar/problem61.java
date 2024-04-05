package Seminar;

import java.util.Arrays;
import java.util.HashMap;

import acm.program.ConsoleProgram;

public class problem61 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem61().start();
  }

  public void run() {
    int m = readInt("Enter a number: ");
    int n = readInt("Enter index: ");
    int[] arr = new int[n];
    readArr(arr);
    println(Arrays.toString(findTwoMatches(arr, m)));
  }

  private int[] findTwoMatches(int[] arr, int m) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int secondNum = m - arr[i];
      if (map.containsKey(secondNum))
        return new int[] { secondNum, map.get(secondNum) };
      map.put(arr[i], secondNum);
    }
    return null;
  }

  private void readArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = readInt("Enter nums: ");
    }
  }
}
