package sorting.quicksort;

import java.util.Arrays;

import static utils.SortingHelper.swap;

// 알고리즘 입문 도서 버전 퀵 정렬
public class QuickSortV2 {

    static void quickSort(int[] arr, int left , int right) {
        int pl = left;
        int pr = right;

        int pivot = arr[(left + right) / 2];

        while (pl <= pr) {
            while (arr[pl] < pivot) pl++;
            while (arr[pr] > pivot) pr--;
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        }

        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl, right);
    }

    // 피벗 선택 개선 버전
    static void quickSortWithMedianPivot(int[] arr, int left , int right) {
        int pl = left;
        int pr = right;
        int mid = sort3elem(arr, pl, (pl + pr) / 2, pr);

        int pivot = arr[mid];

        swap(arr, mid, right - 1);
        pl++;
        pr-=2;

        while (pl <= pr) {
            while (arr[pl] < pivot) pl++;
            while (arr[pr] > pivot) pr--;
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        }

        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl, right);
    }

    private static int sort3elem(int[] arr, int first, int mid, int last) {
        if (arr[first] > arr[mid]) swap(arr, first, mid);
        if (arr[mid] > arr[last]) swap(arr, mid, last);
        if (arr[first] > arr[mid]) swap(arr, first, mid);
        return mid;
    }

    public static void main(String[] args) {
        int[] test1 = {5, 7, 1, 4, 6, 2, 3, 9, 8};
        int[] test2 = {1, 8, 7, 4, 5, 2, 6, 3, 9};

        quickSort(test1, 0, test1.length - 1);
        System.out.println(Arrays.toString(test1));
        quickSort(test2, 0, test2.length - 1);
        System.out.println(Arrays.toString(test2));

        quickSortWithMedianPivot(test1, 0, test1.length - 1);
        System.out.println(Arrays.toString(test1));
        quickSortWithMedianPivot(test2, 0, test2.length - 1);
        System.out.println(Arrays.toString(test2));
    }

}
