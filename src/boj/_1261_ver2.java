package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 알고스팟
 */
public class _1261_ver2 {

    private static class Algospot {
        int y;
        int x;
        int wall;

        public Algospot(int y, int x, int wall) {
            this.y = y;
            this.x = x;
            this.wall = wall;
        }
    }

    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String walls = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = walls.charAt(j);
        }
        br.close();

        dijkstra(map, N, M);
    }

    private static void dijkstra(char[][] map, int N, int M) {
        PriorityQueue<Algospot> pq = new PriorityQueue<>(Comparator.comparingInt(al -> al.wall));
        pq.add(new Algospot(0, 0, 0));

        int[][] visited = new int[N][M];
        for (int[] v : visited)
            Arrays.fill(v, Integer.MAX_VALUE);
        visited[0][0] = 0;

        while (!pq.isEmpty()) {
            Algospot now = pq.poll();

            if (now.y == N - 1 && now.x == M - 1) {
                System.out.println(now.wall);
                return;
            }

            for (int i = 0; i < dy.length; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (!(0 <= ny && ny < N && 0 <= nx && nx < M))
                    continue;

                int nextWall = map[ny][nx] == '1' ? now.wall + 1 : now.wall;
                if (nextWall < visited[ny][nx]) {
                    visited[ny][nx] = nextWall;
                    pq.add(new Algospot(ny, nx, nextWall));
                }
            }
        }
    }

}