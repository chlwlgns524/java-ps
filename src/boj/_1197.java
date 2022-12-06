package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최소 스패닝 트리
 */
public class _1197 {

    private static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[] parent = makeForest(V);

        Queue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }
        br.close();

        int numberOfEdges = 0;
        int minimumCost = 0;

        while (!edges.isEmpty()){
            Edge e = edges.poll();
            int from = e.from;
            int to = e.to;
            int cost = e.cost;

            if (find(from, parent) != find(to, parent)) {
                union(from, to, parent);
                numberOfEdges++;
                minimumCost += cost;
                if (numberOfEdges == V - 1)
                    break;
            }
        }

        System.out.println(minimumCost);
    }

    private static int[] makeForest(int V) {
        int[] forest = new int[V + 1];
        for (int i = 0; i < forest.length; i++)
            forest[i] = i;
        return forest;
    }

    private static int find(int child, int[] parent) {
        if (parent[child] == child)
            return child;
        return parent[child] = find(parent[child], parent);
    }

    private static void union(int x, int y, int[] parent) {
        x = find(x, parent);
        y = find(y, parent);

        if (x == y)
            return;

        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

}
