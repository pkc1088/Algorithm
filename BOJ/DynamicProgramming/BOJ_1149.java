package BOJ.DynamicProgramming;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1149 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static int[][] dp, cost;
    static boolean[][] visited;
    static int n, a, b, c, ans;
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        cost = new int[n][3]; // R0, G1, B2
        //visited = new boolean[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.
        for (int i = 1; i < n; i++) {
            cost[i][Red] += Math.min(cost[i - 1][Green], cost[i - 1][Blue]);
            cost[i][Green] += Math.min(cost[i - 1][Red], cost[i - 1][Blue]);
            cost[i][Blue] += Math.min(cost[i - 1][Red], cost[i - 1][Green]);
        }
        System.out.println(Math.min(Math.min(cost[n - 1][0], cost[n - 1][1]), cost[n - 1][2]));
    }
}