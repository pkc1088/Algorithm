package BOJ.PriorityQueue;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1927 {
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
    static int n, m, k, a, b, c, ans = 0, cnt = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // new PriorityQueue<Integer>(Collections.reverseOrder());
        // new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        for (int i = 1; i < n + 1; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0)
                pq.add(x);
            else {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
        }
    }

    private static void print() {
        for (int i = 1; i < brr.length; i++) {
            System.out.print(brr[i] + " ");
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