package ds;

import java.util.Stack;
import mooc.EdxIO;

public class StackUsage {

  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      Stack<Integer> stack = new Stack<>();
      int n = io.nextInt();
      for (int i = 0; i < n; i++) {
        char action = io.nextChar();
        if (action == '+') {
          stack.push(io.nextInt());
        } else {
          io.println(stack.pop());
        }
      }
    }
  }
}
