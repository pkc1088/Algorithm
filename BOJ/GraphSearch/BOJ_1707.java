package BOJ.GraphSearch;


import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import static java.lang.System.exit;

public class BOJ_1707 {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<ArrayList<Integer>> graph;
    static HashMap<Integer, Integer> hm;
    static ArrayList<Integer> list, list2, list3;
    static Queue<Integer> que;
    static String str, str1, str2;
    static Queue<int[]> queue;
    static boolean[][] visited;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board, origin;
    static int[] dp, brr, arr, check, result, color;
    static int[] rx = {-1, 1,  0, 0};
    static int[] ry = { 0, 0, -1, 1};
    static int tc, n, m, v, e, h, r, k, a, b, c, count, ans, cnt, sum;
    static boolean dupli_visit = false;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        for (int i = 1; i < tc + 1; i++) {
            solution();
        }
    }
    public static void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        que = new LinkedList<>();
        graph = new ArrayList<>(); for (int i = 0; i < v + 1; i++) graph.add(new ArrayList<>());
        visit = new boolean[v + 1];
        color = new int[v + 1];

        for (int i = 1; i < e + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 1; i < v + 1; i++) {
            if(color[i] == 0) {
                que.add(i);
                color[i] = 7; // 임의의 값 7
                bfs();
            }
        }

        if(dupli_visit) System.out.println("NO");
        else System.out.println("YES");
        dupli_visit = false;
    }

    private static void bfs() {
        while(!que.isEmpty()) {
            int cur = que.poll();
            System.out.println("cur "+cur+"-------------");
            for(int next : graph.get(cur)) {
                System.out.println("next "+next);
                if(color[next] == 0) {  // 아직 순수한 얘면 반전시킨값으로 초기화 시켜줌
                    color[next] = color[cur] * -1;
                    que.add(next);
                } else if(color[next] == color[cur]) {
                    // 이미 연결된 얘가 자신의 컬러와 같게 초기화 되어있으면 문제임
                    System.out.println("next "+next + "and cur "+cur +"is same");
                    dupli_visit = true;
                    return;
                }


            }
        }

    }
}
