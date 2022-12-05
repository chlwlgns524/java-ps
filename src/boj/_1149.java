package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * RGB거리
 */
public class _1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int currentHouse = 1; currentHouse < N; currentHouse++) {
            for (int currentColor = 0; currentColor < 3; currentColor++) {
                int previousCost = Integer.MAX_VALUE;
                for (int previousColor = 0; previousColor < 3; previousColor++) {
                    if (currentColor != previousColor)
                        previousCost = Integer.min(previousCost, cost[currentHouse - 1][previousColor]);
                }
                cost[currentHouse][currentColor] += previousCost;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(getMin(cost[N - 1]));
        bw.flush();
        bw.close();
    }

    private static String getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int value : arr)
            if (value < min)
                min = value;
        return Integer.toString(min);
    }

}
