package sorting;

import mooc.EdxIO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MergeSortTest {

  @Test
  public void testMerge() {
    int[] arr = {3, 1, 1, 4, 7, 2, 3, 5};
    int li = 2;
    int ri = arr.length - 1;
    int mid = li + (ri - li + 1) / 2;
    MergeSort.merge(arr, li, ri, mid, new int[arr.length], EdxIO.create());
    Assert.assertEquals(arr, new int[]{3, 1, 1, 2, 3, 4, 5, 7});
  }

  @Test
  public void testSort() {
    int[] arr = {3, 1, 1, 10, 4, 7, 2, 3, 5};
    MergeSort.sort(arr, EdxIO.create());
    Assert.assertEquals(arr, new int[]{1, 1, 2, 3, 3, 4, 5, 7, 10});
  }
}