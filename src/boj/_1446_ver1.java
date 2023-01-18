package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 지름길
 */
public class _1446_ver1 {

    private static class Shortcut {
        int from;
        int dist;

        public Shortcut(int from, int dist) {
            this.from = from;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Map<Integer, List<Shortcut>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (!(dist >= to - from || to > D)) {
                List<Shortcut> shortcuts = map.getOrDefault(to, new ArrayList<>());
                shortcuts.add(new Shortcut(from, dist));
                map.put(to, shortcuts);
            }
        }
        br.close();

        int[] dp = new int[D + 1];
        int now = 1;
        while (now <= D) {
            dp[now] = dp[now - 1] + 1;

            if (map.containsKey(now)) {
                for (Shortcut shortcut : map.get(now))
                    dp[now] = Math.min(dp[now], dp[shortcut.from] + shortcut.dist);
            }

            now++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(dp[D]));
        bw.flush();
        bw.close();
    }

}
