package sorting;

import mooc.EdxIO;

public class RadixIntegerSort {

  private static final int BITS_PER_BYTE = 8;

  public static long bruteSolve(int[] m) {
    sort(m);
    long sum = 0;
    for (int i = 0; i < m.length; i += 10) {
      sum += m[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      int n = io.nextInt();
      int m = io.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = io.nextInt();
      }
      int k = 0;
      int[] mul = new int[n * m];
      for (int i = 0; i < m; i++) {
        int r = io.nextInt();
        for (int j = 0; j < n; j++) {
          mul[k] = r * a[j];
          k++;
        }
      }
      io.print(Long.toString(bruteSolve(mul)));
    }
  }


  /**
   * Rearranges the array of 32-bit integers in ascending order.
   * This is about 2-3x faster than Arrays.sort().
   *
   * @param a the array to be sorted
   */
  public static void sort(int[] a) {
    final int BITS = 32;                 // each int is 32 bits
    final int R = 1 << BITS_PER_BYTE;    // each bytes is between 0 and 255
    final int MASK = R - 1;              // 0xFF
    final int w = BITS / BITS_PER_BYTE;  // each int is 4 bytes

    int n = a.length;
    int[] aux = new int[n];

    for (int d = 0; d < w; d++) {

      // compute frequency counts
      int[] count = new int[R + 1];
      for (int i = 0; i < n; i++) {
        int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
        count[c + 1]++;
      }

      // compute cumulates
      for (int r = 0; r < R; r++) {
        count[r + 1] += count[r];
      }

      // for most significant byte, 0x80-0xFF comes before 0x00-0x7F
      if (d == w - 1) {
        int shift1 = count[R] - count[R / 2];
        int shift2 = count[R / 2];
        for (int r = 0; r < R / 2; r++) {
          count[r] += shift1;
        }
        for (int r = R / 2; r < R; r++) {
          count[r] -= shift2;
        }
      }

      // move data
      for (int i = 0; i < n; i++) {
        int c = (a[i] >> BITS_PER_BYTE * d) & MASK;
        aux[count[c]++] = a[i];
      }

      // copy back
      for (int i = 0; i < n; i++) {
        a[i] = aux[i];
      }
    }
  }


}
