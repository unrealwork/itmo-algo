package sorting;

import mooc.EdxIO;

public class ScarecrowSort {

  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      int n = io.nextInt();
      int k = io.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = io.nextInt();
      }
      String answer = solve(arr, k) ? "YES" : "NO";
      io.print(answer);
    }
  }

  private static void exch(int[] ar, int j, int i) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }

  private static void order(int[] ar, int start, int step) {
    // Fill up this function
    for (int i = start; i < ar.length - step; i += step) {
      for (int j = i; j >= start; j -= step) {
        if (ar[j] > ar[j + step]) {
          exch(ar, j, j + step);
        }
      }
    }
  }


  private static boolean solve(int[] arr, int k) {
    if (k < 2) {
      return true;
    }
    for (int i = 0; i < k; i++) {
      sort(arr, i, arr.length - 1, k);
    }
    return isSorted(arr);
  }

  private static int partition(int[] arr, int li, int ri, int step) {
    int j = li;
    int pivot = arr[li];
    int lastIndex = li + ((ri - li) / step) * step;
    exch(arr, li, lastIndex);
    for (int i = li; i <= lastIndex; i += step) {
      if (arr[i] < pivot) {
        exch(arr, i, j);
        j += step;
      }

    }
    exch(arr, lastIndex, j);
    return j;
  }

  private static void sort(int[] a, int lo, int hi, int step) {
    if (hi <= lo) {
      return;
    }
    int j = partition(a, lo, hi, step);
    sort(a, lo, j - step, step);
    sort(a, j + step, hi, step);
  }

  private static boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < arr[i - 1]) {
        return false;
      }
    }
    return true;
  }
}
