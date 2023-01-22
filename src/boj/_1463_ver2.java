package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기
 */
public class _1463_ver2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        br.close();

        int[] dp = new int[X + 1];
        for (int num = X - 1; num >= 1; num--) {
            dp[num] = dp[num + 1] + 1;

            if (num * 3 <= X)
                dp[num] = Integer.min(dp[num], dp[num * 3] + 1);
            if (num * 2 <= X)
                dp[num] = Integer.min(dp[num], dp[num * 2] + 1);
        }

        System.out.println(dp[1]);
    }

}
