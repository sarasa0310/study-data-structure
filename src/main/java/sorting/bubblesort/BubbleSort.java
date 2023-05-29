package sorting.bubblesort;

import utils.SortingHelper;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] input) {
        boolean isUnsorted = true;

        while (isUnsorted) {
            isUnsorted = false;

            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    SortingHelper.swap(input, i, i + 1);
                    isUnsorted = true;
                }
            }
        }

        return input;
    }

    public static void main(String[] args) {
        int[] test = {1, 8, 3, 6, 25, 76, 33, 92, 12, 55};

        System.out.println(Arrays.toString(test));

        bubbleSort(test);

        System.out.println(Arrays.toString(test));
    }
}
