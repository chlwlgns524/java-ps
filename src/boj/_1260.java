package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DFS와 BFS
 */

public class _1260 {

    private static final ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++)
            edge.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (!edge.get(from).contains(to)) {
                edge.get(from).add(to);
                edge.get(to).add(from);
            }
        }
        br.close();

        for (int i = 1; i <= N; i++)
            Collections.sort( edge.get(i));

        dfs(V);

        System.out.println();
        Arrays.fill(visited, false);

        bfs(V);
    }

    private static void dfs(int startNode) {
        visited[startNode] = true;
        System.out.print(String.valueOf(startNode).concat(" "));

        for (int i = 0, size = edge.get(startNode).size(); i < size; i++) {
            int next = edge.get(startNode).get(i);

            if (!visited[next])
                dfs(next);
        }
    }

    private static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();

        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            Integer currentNode = q.poll();
            System.out.print(String.valueOf(currentNode).concat(" "));

            for (int i = 0, size = edge.get(currentNode).size(); i < size; i++) {
                int nextNode = edge.get(currentNode).get(i);

                if (!visited[nextNode]) {
                    q.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

}