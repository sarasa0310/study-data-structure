package primenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eratosthenes {
    public static void main(String[] args) {
//        List<Integer> primeNumbers = solution(100);
        int[] primeNumbersV2 = solutionV2(10);
//        System.out.println(primeNumbers);
        System.out.println(Arrays.toString(primeNumbersV2));
    }

    public static List<Integer> solution(int n) {
        List<Integer> rowNumbers = new ArrayList<>();
        List<Boolean> mark = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            rowNumbers.add(i);
            mark.add(true);
        }

        for (int i = 0; i < rowNumbers.size(); i++) {
            if (mark.get(i)) {
                for (int j = i + 1; j < rowNumbers.size(); j++) {
                    if (rowNumbers.get(j) % rowNumbers.get(i) == 0) {
                        mark.set(j, false);
                    }
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = 0; i < rowNumbers.size(); i++) {
            if (mark.get(i)) {
                primeNumbers.add(rowNumbers.get(i));
            }
        }

        return primeNumbers;
    }

    public static int[] solutionV2(int limit) {
        boolean[] output = new boolean[limit + 1];

        Arrays.fill(output, true);

        output[0] = false;
        output[1] = false;

        System.out.println(Arrays.toString(output));

        for (int i = 2; i <= Math.pow(limit, 0.5); i++) {
            if (output[i]) {
                for (int j = (int) Math.pow(i, 2); j <= limit; j = j + i) {
                    output[j] = false;
                }
            }
        }

        System.out.println(Arrays.toString(output));

        int count = 0;

        for (boolean el : output) {
            if (el) count++;
        }

        System.out.println(count);

        int[] result = new int[count];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < output.length; j++) {
                if (output[j]) {
                    result[i++] = j;
                }
            }
        }

        return result;
    }
}
