// 70. Climbing Stairs

import java.util.HashMap;

class Solution {
    public int climb(int n, int curr, int[][] dp) {
        if (dp[n][curr] != -1) {
            return dp[n][curr];
        }
        if (curr == n) {
            return 1;
        }
        if (curr > n) {
            return 0;
        }
        int singleSteps = climb(n, curr + 1, dp);
        int doubleSteps = climb(n, curr + 2, dp);
        dp[n][curr] = singleSteps + doubleSteps;

        return singleSteps + doubleSteps;
    }

    public int climbStairs(int n) {
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return climb(n, 0, dp);
    }
}
