package sorting;

import mooc.EdxIO;

public class AntiQuickSort {

  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      int n = io.nextInt();
      int[] arr = solve(n);
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < n; i++) {
        builder.append(arr[i]).append(' ');
      }
      io.print(builder.toString());
    }
  }

  private static void solve(int n, int[] arr) {
    int i;
    for (i = 0; i < n && i < 2; i++) {
      arr[i] = i + 1;
    }
    for (i = 3; i <= n; i++) {
      int mid = (i - 1) / 2;
      exch(arr, mid, i - 1);
      arr[mid] = i;
    }
  }

  private static void exch(int[] ar, int j, int i) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }

  private static int[] solve(int n) {
    int[] arr = new int[n];
    solve(n, arr);
    return arr;
  }
}
