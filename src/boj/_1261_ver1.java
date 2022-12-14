package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 알고스팟
 */
public class _1261_ver1 {

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

        bfs(map, N, M);
    }

    private static void bfs(char[][] map, int N, int M) {
        Queue<Algospot> q = new LinkedList<>();
        q.add(new Algospot(0, 0, 0));

        int[][] minWall = new int[N][M];
        for (int i = 0; i < N; i++)
            Arrays.fill(minWall[i], Integer.MAX_VALUE);
        minWall[0][0] = 0;

        while (!q.isEmpty()) {
            Algospot now = q.poll();

            if (now.y == N - 1 && now.x == M - 1) {
                minWall[now.y][now.x] = Math.min(minWall[now.y][now.x], now.wall);
                continue;
            }

            for (int i = 0; i < dy.length; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (!(0 <= ny && ny < N && 0 <= nx && nx < M))
                    continue;

                int nextWall = map[ny][nx] == '1' ? now.wall + 1 : now.wall;
                if (nextWall < minWall[ny][nx]) {
                    minWall[ny][nx] = nextWall;
                    q.add(new Algospot(ny, nx, nextWall));
                }
            }
        }

        System.out.println(minWall[N - 1][M - 1]);
    }

}
