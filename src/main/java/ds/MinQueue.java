package ds;

import java.util.LinkedList;
import java.util.Queue;
import mooc.EdxIO;

public class MinQueue {

  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      Queue<Integer> queue = new LinkedList<>();
      int n = io.nextInt();
      for (int i = 0; i < n; i++) {
        char action = io.nextChar();
        if (action == '+') {
          int number = io.nextInt();
          queue.add(number);
        } else if (action == '-') {
          queue.remove();
        } else {
        }
      }
    }
  }

}
