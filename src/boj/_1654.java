package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 랜선 자르기
 */
public class _1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] cables = new int[K];
        for (int i = 0; i < K; i++)
            cables[i] = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(findOptimalLength(N, cables));
    }

    private static long findOptimalLength(int N, int[] cables) {
        long left = 1;
        long right = Integer.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;

            final int unit = (int) mid;
            long count = Arrays.stream(cables)
                    .map(cable -> cable / unit)
                    .sum();

            if (count < N)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return right;
    }

}
