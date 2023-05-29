package sorting.mergesort;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return arr;

        int mid = Math.floorDiv(len, 2);
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, len);

        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];

        int leftPos = 0, rightPos = 0, curIdx = 0;

        while (left.length > leftPos && right.length > rightPos) {
            merged[curIdx++] = (left[leftPos] < right[rightPos]) ? left[leftPos++] : right[rightPos++];
        }

        System.arraycopy(left, leftPos, merged, curIdx, left.length - leftPos);
        System.arraycopy(right, rightPos, merged, curIdx, right.length - rightPos);

        return merged;
    }

    public static void main(String[] args) {
        int[] test = {9,8,7,6,5,4,3,2,1};
        int[] test2 = {5, 19, 34, 11, 22, 98, 1, 67, 39, 22, 87, 44, 22};

        MergeSort m = new MergeSort();

        int[] sorted = m.sort(test);
        int[] sorted2 = m.sort(test2);

        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(sorted2));
    }

}
