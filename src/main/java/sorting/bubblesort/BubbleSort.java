package sorting.bubblesort;

import utils.SortingHelper;

import java.util.Arrays;

public class BubbleSort {

    public static void standardBubbleSort(int[] input) {
        int len = input.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    SortingHelper.swap(input, j, j + 1);
                }
            }
        }
    }

    public static void improvedBubbleSort(int[] input) {
        boolean swap = true;

        while (swap) {
            swap = false;

            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    SortingHelper.swap(input, i, i + 1);
                    swap = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 8, 3, 6, 25, 76, 33, 92, 12, 55};
        int[] test2 = {1, 8, 3, 6, 25, 76, 33, 92, 12, 55};

        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(test2));

        improvedBubbleSort(test);
        standardBubbleSort(test2);

        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(test2));
    }

}
