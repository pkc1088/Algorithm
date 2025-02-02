package BOJ.PriorityQueue;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_13975 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static String str, str1, str2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board, origin;
    static int[] dp, brr, arr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0, sum = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i < tc + 1; i++) {
            file_shit();
        }
    }
    /*
    c1 c2 c3 c4
    40 30 30 50
    (c1+c2) + (c3+c4) = ((40+30)+(30+50)) =cal=> (70+80) =cal=> 150
    전체 (a+b) 형태에서 더해지는 a와 b가 매번 최소가 되면 됨
    즉 60 + 100 > 70 + 80 임 모든 파일에 대해서.
    즉 매 시퀀스마다 전체 파일합치는 시퀀스가 최소가 되도록 유지만 하면 됨 각 시퀀스가
*/
    public static void file_shit() throws IOException {
        n = Integer.parseInt(br.readLine());
        long sum = 0;
        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        Long a, b;
        while(!pq.isEmpty()) {
            a = pq.poll();
            b = pq.poll();

            if (a == null || b == null) {
                break;
            }
            if (a + b > 1) {
                pq.add(a + b);
            }
            sum += a + b;
        }
        System.out.println(sum);
    }

    private static void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    private static void print2() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}