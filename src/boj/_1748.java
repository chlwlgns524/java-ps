package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수 이어 쓰기 1
 */
public class _1748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(sum(N, 1, 10));
    }

    private static int sum(int N, int left, int right) {
        if (left <= N && N < right)
            return (N - left + 1) * getNumberOfDigits(left);
        return (right - left) * getNumberOfDigits(left) +
                sum(N, left * 10, right * 10);
    }

    private static int getNumberOfDigits(int number) {
        int digits = 1;
        while ((number /= 10 ) > 0)
            digits++;
        return digits;
    }

}
