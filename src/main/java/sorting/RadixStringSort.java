package sorting;

import mooc.EdxIO;

public class RadixStringSort {

  private static final int LEFT_BOUND = 'a';
  private static final char WHITESPACE = ' ';

  public static void main(String[] args) {
    try (final EdxIO io = EdxIO.create()) {
      final int n = io.nextInt();
      final int m = io.nextInt();
      final int k = io.nextInt();
      final byte[][] words = new byte[m][];

      for (int i = 0; i < m; i++) {
        words[i] = io.nextBytes();
      }
      final int[] indexes = solve(words, n, m, k);
      for (int i = 0; i < n; i++) {
        io.print(indexes[i] + 1).print(WHITESPACE);
      }
    }
  }

  private static int[] solve(final byte[][] a, final int n, final int m,
      final int k) {
    final int R = 26;   // extend ASCII alphabet size
    int[] indexes = new int[n];
    int[] tmp = new int[n];
    int[] auxIndexes;
    for (int i = 0; i < n; i++) {
      indexes[i] = i;
    }
    final int low = m - k - 1;
    final int high = m - 1;
    for (int d = high; d > low; d--) {
      auxIndexes = tmp;
      // sort by key-indexed counting on dth character
      // compute frequency counts
      final int[] count = new int[R + 1];
      for (int i = 0; i < n; i++) {
        count[a[d][indexes[i]] - LEFT_BOUND + 1]++;
      }

      // compute cumulates
      for (int r = 0; r < count.length - 1; r++) {
        count[r + 1] += count[r];
      }

      // move data
      for (int i = 0; i < n; i++) {
        final int id = indexes[i];
        final byte symbol = a[d][id];
        auxIndexes[count[symbol - LEFT_BOUND]++] = id;
      }
      tmp = indexes;
      indexes = auxIndexes;
    }
    return indexes;
  }
}
