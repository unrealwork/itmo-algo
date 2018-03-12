package ds;

import java.util.LinkedList;
import java.util.Queue;
import mooc.EdxIO;

public class QueueUsage {

  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      Queue<Integer> queue = new LinkedList<>();
      int n = io.nextInt();
      for (int i = 0; i < n; i++) {
        char action = io.nextChar();
        if (action == '+') {
          queue.add(io.nextInt());
        } else {
          io.println(queue.remove());
        }
      }
    }
  }
}
