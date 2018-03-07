package sorting;

import java.util.Arrays;
import java.util.stream.IntStream;
import mooc.EdxIO;

public class Sortland {

  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      int n = io.nextInt();
      Element[] arr = IntStream.range(0, n)
          .mapToObj(num -> new Element<>(num + 1, io.nextDoubleFast()))
          .toArray(Element[]::new);
      Arrays.sort(arr);
      int min = arr[0].getIndex();
      int max = arr[arr.length - 1].getIndex();
      int med = arr[arr.length / 2].getIndex();
      io.println(String.format("%d %d %d", min, med, max));
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
