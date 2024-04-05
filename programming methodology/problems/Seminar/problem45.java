package Seminar;

import acm.program.ConsoleProgram;

public class problem45 extends ConsoleProgram {
  public static void main(String[] args) {
    new problem45().start();
  }

  public void run() {
    String text = readLine("Enter a text: ");
    char symbol = readCh();
    findSymbol(text, symbol);
  }

  private void findSymbol(String text, char symbol) {
    int sum = 0;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == symbol)
        sum++;
    }
    println("symbol \"" + symbol + "\" repeats " + sum + " times in this text.");
  }

  private char readCh() {
    String str;
    while (true) {
      str = readLine("Enter a symbol: ");
      if (str.length() == 1)
        break;
      else
        println("Invalide symbol");
    }
    return str.charAt(0);
  }
}
