package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 곱셈
 */
public class _1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(pow(A, B, C) + "\n");
        bw.flush();
        bw.close();
    }

    private static long pow(long base, int exp, int m) {
        if (exp == 0)
            return 1;
        else if (exp == 1)
            return base % m;
        else if (exp % 2 == 0) {
            long temp = pow(base, exp / 2, m);
            return (temp * temp) % m;
        }
        else {
            long temp = pow(base, exp - 1, m);
            return (base * temp) % m;
        }
    }

}
