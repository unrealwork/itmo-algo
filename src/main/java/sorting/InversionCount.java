package sorting;

import java.util.stream.IntStream;
import mooc.EdxIO;

public class InversionCount {

  public static long mergesort(int[] array) {
    return mergesort(array, new int[array.length], 0, array.length - 1);
  }

  private static long mergesort(int[] array, int[] temp, int li, int ri) {
    if (li >= ri) {
      return 0;
    }
    int middle = (li + ri) / 2;
    return mergesort(array, temp, li, middle) +
        mergesort(array, temp, middle + 1, ri) +
        mergeHalves(array, temp, li, ri);
  }

  private static long mergeHalves(int[] array, int[] temp, int li, int ri) {
    long result = 0;
    int leftEnd = (ri + li) / 2;
    int rightStart = leftEnd + 1;
    int size = ri - li + 1;

    int left = li;
    int right = rightStart;
    int index = li;

    while (left <= leftEnd && right <= ri) {
      if (array[left] <= array[right]) {
        temp[index] = array[left];
        left++;
      } else {
        temp[index] = array[right];
        right++;
        result += (leftEnd + 1 - left);
      }
      index++;
    }
    System.arraycopy(array, left, temp, index, leftEnd - left + 1);
    System.arraycopy(array, right, temp, index, ri - right + 1);
    System.arraycopy(temp, li, array, li, size);

    return result;
  }

  public static void main(String[] args) {
    try (EdxIO io = EdxIO.create()) {
      int n = io.nextInt();
      int[] arr = IntStream.range(0, n).map(i -> io.nextInt()).toArray();
      io.print(mergesort(arr));
    }
  }
}
