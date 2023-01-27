package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질
 */
public class _1697 {

    private static class Pos {
        int pos;
        int seconds;

        public Pos(int pos, int seconds) {
            this.pos = pos;
            this.seconds = seconds;
        }
    }

    private static final int UPPER_LIMIT = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(findBrother(N, K));
    }

    private static int findBrother(int start, int target) {
        char[] moveType = {'+', '-', '*'};
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(start, 0));

        boolean[] visited = new boolean[UPPER_LIMIT + 1];
        visited[start] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            if (now.pos == target)
                return now.seconds;

            for (char type : moveType)
                move(now, type, queue, visited);
        }

        return -1;
    }

    private static void move(Pos now, char type, Queue<Pos> queue, boolean[] visited) {
        int nextPos = now.pos;
        int nextSeconds = now.seconds + 1;
        switch (type) {
            case '+' -> nextPos++;
            case '-' -> nextPos--;
            case '*' -> nextPos *= 2;
        }

        if (0 <= nextPos && nextPos <= UPPER_LIMIT && !visited[nextPos]) {
            visited[nextPos] = true;
            queue.add(new Pos(nextPos, nextSeconds));
        }
    }

}
