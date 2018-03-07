package sorting;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import mooc.EdxIO;

public class SwapSecretary {

  private static final String SWAP_MESSAGE = "Swap elements at indices %d and %d.";
  private static final String NO_SWAP_MESSAGE = "No more swaps needed.";

  private static void minFindSort(int[] ar,
      BiConsumer<Integer, Integer> swapEvent) {
    // Fill up this function
    for (int i = 0; i < ar.length - 1; i++) {
      int minIndex = findMin(ar, i);
      exch(ar, i, minIndex);
      if (i != minIndex) {
        swapEvent.accept(i + 1, minIndex + 1);
      }
    }
  }

  private static int findMin(int[] ar, int start) {
    int min = ar[start];
    int minIndex = start;
    for (int i = start + 1; i < ar.length; i++) {
      if (ar[i] < min) {
        min = ar[i];
        minIndex = i;
      }
    }
    return minIndex;
  }

  private static void exch(int[] ar, int j, int i) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }


  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      int n = io.nextInt();
      int[] arr = IntStream.range(0, n).map(i -> io.nextInt()).toArray();
      minFindSort(arr, (i, j) -> io.println(String.format(SWAP_MESSAGE, i, j)));
      io.println(NO_SWAP_MESSAGE);
      Arrays.stream(arr).forEach(num -> io.print(String.format("%d ", num)));
    }
  }

  private static class Element<T extends Comparable<T>> implements
      Comparable<Element<T>> {

    private int index;
    private T value;

    public Element(int index, T value) {
      this.index = index;
      this.value = value;
    }

    public int getIndex() {
      return index;
    }

    public T getValue() {
      return value;
    }

    @Override
    public int compareTo(Element<T> o) {
      return value.compareTo(o.value);
    }
  }
}
