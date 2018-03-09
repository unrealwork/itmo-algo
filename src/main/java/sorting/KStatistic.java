package sorting;

import java.util.Arrays;
import java.util.Random;
import mooc.EdxIO;

public class KStatistic {

  private static final Random RANDOM = new Random();

  private static void quickSelect(int[] arr, int li, int ri, int k) {
    if (li < ri) {
      int pivotIndex = partition(arr, li, ri, k);
      if (k == pivotIndex) {
        return;
      } else {
        if (k > pivotIndex) {
          quickSelect(arr, pivotIndex + 1, ri, k);
        } else {
          quickSelect(arr, li, pivotIndex - 1, k);
        }
      }
    }
  }


  private static int partition(int[] arr, int li, int ri, int k) {
    int j = li;
    int pivotIndex = li + RANDOM.nextInt(ri - li + 1);
    int pivot = arr[pivotIndex];
    exch(arr, pivotIndex, ri);
    for (int i = li; i <= ri; i++) {
      if (arr[i] < pivot) {
        exch(arr, i, j);
        j++;
      }
    }
    exch(arr, ri, j);
    // Find pivot nearest to kth element
    for (int i = j + 1; i <= ri && j < k && j < ri; i++) {
      if (arr[i] == arr[j]) {
        exch(arr, j + 1, i);
        j++;
      }
    }
    return j;
  }


  private static void exch(int[] ar, int j, int i) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }


  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      int n = io.nextInt();
      int k1 = io.nextInt() - 1;
      int k2 = io.nextInt() - 1;
      int[] arr = new int[n];
      int a = io.nextInt();
      int b = io.nextInt();
      int c = io.nextInt();
      arr[0] = io.nextInt();
      arr[1] = io.nextInt();
      for (int i = 2; i < n; i++) {
        arr[i] = a * arr[i - 2] + b * arr[i - 1] + c;
      }
      solve(arr, k1, k2);
      StringBuilder buffer = new StringBuilder();
      for (int i = k1; i <= k2; i++) {
        buffer.append(arr[i]).append(' ');
      }
      io.println(buffer.toString());
    }

  }

  private static void solve(int[] arr, int k1, int k2) {
    quickSelect(arr, 0, arr.length - 1, k1);
    quickSelect(arr, k1 + 1, arr.length - 1, k2);
    if (k2 - k1 > 2) {
      Arrays.sort(arr, k1 + 1, k2);
    }
  }
}
