package BOJ;


import BOJ.DynamicProgramming.BOJ_1463;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static int[][] dpp;
    static int[] dp;
    static int[][] arr;
    static boolean[][] visited;
    static int n, a, b, c, ans, cnt = 0;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        //dp[1] = 9;
        //dp[2] = 17;
        for (int i = 2; i <= n; i++) {
            // edge case 앞쪽

            // 가운데 case
            dp[i] = dp[i - 1] * 2;

            // edge case 뒷쪽
        }
        /*
        길이가 2인 계단 수
        12, 10
        23, 21
        34, 32
        4
        56, 54
        6
        7
        89, 87
        xx, 98 => 2x8 + 1 = 17개

        길이가 3인 계단 수
        123, 121, 101, xxx
        234, 232, 210, 212
        345, 343, 321, 323
        4
        567, 565, 543, 545
        6
        789, 787, 765, 767
        xxx, 898, 876, 878
        xxx, xxx, 987, 989

        길이가 4인 계단 수
        1234
        ..
        5678, 5676, 5656, 5654, 5432, 5434, 5454, 5456
        ..

        즉 dp[4]의 경우 dp[3]의 숫자에서 -1, +1로 분기가 가능함 그래서 가운데 케이스는 항상 x2
        근데 -1, +1할 때 edge 되는걸 잘 필터링 해야함.
        */


    }

    public static void print() {
        for (int i = 1; i <= n; i++) {
            System.out.println("dp["+i+"] = " + dp[i]);
        }
    }
}












