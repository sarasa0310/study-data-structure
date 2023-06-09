package knapsack;

public class Knapsack {
    public static void main(String[] args) {
        int weightCap = 8;
        int[] weights = {2, 3, 4, 5};
        int[] values = {1, 2, 5, 6};

        System.out.println(recursive(weightCap, weights, values, weights.length));
        System.out.println(dp(weightCap, weights, values, weights.length));
    }

    public static int dp(int weightCap, int[] weights, int[] values, int n) {
        int[][] matrix = new int[n + 1][weightCap + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= weightCap; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                }
                else if (weights[i - 1] <= j) {
                    matrix[i][j] = Math.max(
                            values[i - 1] + matrix[i - 1][j - weights[i - 1]],
                            matrix[i - 1][j]
                    );
                }
                else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        return matrix[n][weightCap];
    }

    public static int recursive(int weightCap, int[] weights, int[] values, int n) {
        if (weightCap == 0 || n == 0) {
            return 0;
        }
        else if (weights[n - 1] > weightCap) {
            return recursive(weightCap, weights, values, n - 1);
        }
        else {
            return Math.max(
                    values[n - 1] + recursive(weightCap - weights[n - 1], weights, values, n - 1),
                    recursive(weightCap, weights, values, n - 1)
            );
        }
    }

}