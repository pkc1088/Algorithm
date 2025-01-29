package BOJ.DivideConquer;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_2740 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static String str, str1, str2;
    static Long[] city, road;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board, mat1, mat2;
    static int[] dp, brr, arr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0, one = 0, zero = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n1, n2, m1, m2;

    public static void main(String[] args) throws IOException {

        preprocess();
        /*
        1 2
        3 4     -1 -2 0
        5 6      0  0 3
         */
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < m2 + 1; j++) {
                int t = 0;
                for (int l = 1; l < m1 + 1; l++) {
                    t += mat1[i][l] * mat2[l][j];
                }
                //System.out.println("t is " + t);
                sb.append(t + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

//    private static long remainder(long a, long b, long c) {
//        if (b == 1) {
//            return a % c;
//        }
//        else {
//            long halfVal = remainder(a, b / 2, c);
//
//            if (b % 2 == 1) {
//                return (halfVal * halfVal % c) * a % c;
//            }
//            return halfVal * halfVal % c;
//        }
//    }

    public static void preprocess() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n1 = Integer.parseInt(st.nextToken());
        m1 = Integer.parseInt(st.nextToken());
        mat1 = new int[n1 + 1][m1 + 1];
        for (int i = 1; i < n1 + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < m1 + 1; j++) {
                mat1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        n2 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
        mat2 = new int[n2 + 1][m2 + 1];
        for (int i = 1; i < n2 + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < m2 + 1; j++) {
                mat2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
