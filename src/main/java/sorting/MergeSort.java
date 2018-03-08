package sorting;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import mooc.EdxIO;

public class MergeSort {

  public static void sort(int[] arr,
      EdxIO io) {
    int[] aux = new int[arr.length];
    sort(arr, 0, arr.length - 1, aux, io);
  }

  private static void sort(int[] arr, int li, int ri, int[] aux, EdxIO io) {
    if (li < ri) {
      int mid = li + (ri - li + 1) / 2;
      sort(arr, li, mid - 1, aux, io);
      sort(arr, mid, ri, aux, io);
      merge(arr, li, ri, mid, aux, io);
    }
  }

  static void merge(int[] arr, int li, int ri, int mid, int[] aux,
      EdxIO io) {
    int i = li;
    int j = mid;
    int k = li;
    while (i < mid && j <= ri) {
      if (arr[i] < arr[j]) {
        aux[k] = arr[i];
        i++;
      } else {
        aux[k] = arr[j];
        j++;
      }
      k++;
    }
    if (i < mid) {
      while (i < mid) {
        aux[k] = arr[i];
        i++;
        k++;
      }
    }
    if (j <= ri) {
      while (j <= ri) {
        aux[k] = arr[j];
        j++;
        k++;
      }
    }
    System.arraycopy(aux, li, arr, li, ri - li + 1);
    io.println(String.format("%d %d %d %d", li + 1, ri + 1, arr[li], arr[ri]));
  }

  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      int n = io.nextInt();
      int[] arr = IntStream.range(0, n).map(i -> io.nextInt()).toArray();
      sort(arr, io);
      String res = Arrays.stream(arr).mapToObj(Integer::toString)
          .collect(Collectors.joining(" "));
      io.println(res);
    }
  }
}
