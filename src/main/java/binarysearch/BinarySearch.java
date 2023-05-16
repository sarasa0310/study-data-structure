package binarysearch;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = arr[mid];

            if (midValue == target) return mid;
            else if (midValue < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 100, 34, 27, 54, 33, 87, 24, 67, 69};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        System.out.println(binarySearch(arr, 54));
        System.out.println(binarySearch(arr, 27));
        System.out.println(binarySearch(arr, 34));
        System.out.println(binarySearch(arr, 87));

        System.out.println(Arrays.binarySearch(arr, 54));
        System.out.println(Arrays.binarySearch(arr, 27));
        System.out.println(Arrays.binarySearch(arr, 34));
        System.out.println(Arrays.binarySearch(arr, 87));
    }

}
