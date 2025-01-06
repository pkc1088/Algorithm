import java.io.*;
import java.util.*;


class Point {
    int num;
    int x;
    int y;

    Point(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    double weight;

    Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (weight < o.weight) {
            return -1;
        }
        return 1;
    }

}

public class Main {
    static int[] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Point[] points = new Point[N];
        Edge[] connected = new Edge[M];

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        double ans = 0.00;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(i, x, y);
        }



/*
        edgeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx1 = Integer.parseInt(st.nextToken()) - 1;
            int idx2 = Integer.parseInt(st.nextToken()) - 1;
            double len = distance(points[idx1], points[idx2]);
            edgeList.add(new Edge(idx1, idx2, len));        // 미리 연결해놓고
        }

        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);

            }
        }
*/
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) -1;
            int end = Integer.parseInt(st.nextToken()) -1;

            union(start, end);
        }
////////////


        edgeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double weight = distance(points[i], points[j]);
                edgeList.add(new Edge(points[i].num, points[j].num, weight));
            }
        }
        Collections.sort(edgeList);


        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);

            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                ans += edge.weight;
            }
        }

        System.out.printf("%.2f\n", ans);
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

}
