package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 동물원
 */
public class _1309 {

    private static final int NONE = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int DIVISOR = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[][] dp = new int[N][3];
        dp[0][NONE] = dp[0][LEFT] = dp[0][RIGHT] = 1;
        for (int i = 1; i < N; i++) {
            dp[i][NONE] = (dp[i - 1][NONE] + dp[i - 1][LEFT] + dp[i - 1][RIGHT]) % DIVISOR;
            dp[i][LEFT] = (dp[i - 1][NONE] + dp[i - 1][RIGHT]) % DIVISOR;
            dp[i][RIGHT] = (dp[i - 1][NONE] + dp[i - 1][LEFT]) % DIVISOR;
        }

        System.out.println((dp[N - 1][NONE] + dp[N - 1][LEFT] + dp[N - 1][RIGHT]) % DIVISOR);
    }

}
