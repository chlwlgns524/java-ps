package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 집합의 표현
 */
public class _1717 {

    private static final int UNION_TWO_SETS = 0;
    private static final int CHECK_IF_SAME_PARENT = 1;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        initParent(parent);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case UNION_TWO_SETS -> union(a, b);
                case CHECK_IF_SAME_PARENT -> bw.write(find(a) == find(b) ? "YES\n" : "NO\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void union(int left, int right) {
        int parentOfLeft = find(left);
        int parentOfRight = find(right);

        if (parentOfLeft == parentOfRight)
            return;

        if (left < right)
            parent[parentOfRight] = parentOfLeft;
        else
            parent[parentOfLeft] = parentOfRight;
    }

    public static int find(int child) {
        if (parent[child] == child)
            return child;
        return parent[child] = find(parent[child]);
    }

    private static void initParent(int[] parent) {
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
    }

}
