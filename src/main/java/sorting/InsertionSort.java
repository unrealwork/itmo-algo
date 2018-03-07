package sorting;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import mooc.EdxIO;

public class InsertionSort {

  public static void insertionSortPart(int[] ar, Consumer<Integer> swapEvent) {
    // Fill up this function
    swapEvent.accept(1);
    for (int i = 0; i < ar.length - 1; i++) {
      int lastIndex = i + 1;
      for (int j = i; j >= 0; j--) {
        if (ar[j] > ar[j + 1]) {
          int tmp = ar[j + 1];
          ar[j + 1] = ar[j];
          ar[j] = tmp;
          lastIndex = j;
        }
      }
      swapEvent.accept(lastIndex + 1);
    }
  }

  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      int n = io.nextInt();
      int[] arr = IntStream.range(0, n).map(num -> io.nextInt()).toArray();
      insertionSortPart(arr, index -> io.print(String.format("%d ", index)));
      io.println();
      Arrays.stream(arr).forEach(num -> io.print(String.format("%d ", num)));
    }
  }
}
