package sorting;

import utils.SortingHelper;

import java.util.Arrays;

public class QuickSort {

    public int[] quickSort(int[] arr) {
        if (arr.length <= 1) return arr;
        return quickSort(arr, 0, arr.length - 1);
    }

    public int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partition = partition(arr, start, end);
            if (start < partition) {
                quickSort(arr, start, partition);
            }
            if (partition + 1 < end) {
                quickSort(arr, partition + 1, end);
            }
        }
        return arr;
    }

    public int partition(int[] arr, int leftPointer, int rightPointer) {
        int pivot = arr[Math.floorDiv(leftPointer + rightPointer, 2)];

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] < pivot) {
                leftPointer++;
            }
            while (arr[rightPointer] > pivot) {
                rightPointer--;
            }
            if (leftPointer < rightPointer) {
                SortingHelper.swap(arr, leftPointer, rightPointer);
            }
        }

        return leftPointer;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();

        int[] unsorted = {4, 7, 1, 3, 8, 5, 2, 9, 6};
        System.out.println(Arrays.toString(unsorted));

        int[] sorted = q.quickSort(unsorted);
        System.out.println(Arrays.toString(sorted));
    }

}
