package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1로 만들기
 */
public class _1463_ver1 {

    private static class IntegerToOne {
        int x;
        int cost;

        public IntegerToOne(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(bfs(X));
    }

    private static int bfs(int x) {
        Queue<IntegerToOne> queue = new LinkedList<>();
        queue.add(new IntegerToOne(x, 0));

        boolean[] visited = new boolean[x];

        while (!queue.isEmpty()) {
            IntegerToOne now = queue.poll();

            if (now.x == 1) {
                return now.cost;
            }

            if (!visited[now.x / 2] && (now.x / 2 > 0) && (now.x % 2 == 0)) {
                visited[now.x / 2] = true;
                queue.add(new IntegerToOne(now.x / 2, now.cost + 1));
            }
            if (!visited[now.x / 3] && (now.x / 3 > 0) && (now.x % 3 == 0)) {
                visited[now.x / 3] = true;
                queue.add(new IntegerToOne(now.x / 3, now.cost + 1));
            }
            if (!visited[now.x - 1]) {
                visited[now.x - 1] = true;
                queue.add(new IntegerToOne(now.x - 1, now.cost + 1));
            }
        }

        return -1;
    }

}
