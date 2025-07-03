package BOJ.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_9251 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] arr2, brr2, dp2;
    static int[] arr, brr, dp;
    static int n, m, a, b, c, ans = -1, cnt = 0;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        str1 = br.readLine();
        str2 = br.readLine();
        n = str1.length();
        m = str2.length();
        dp2 = new int[n + 1][m + 1];
        /*
         a c a y k p
       c 0 1 1 1 1 1
       a 1 1 2 2 2 2
       p 1 1 2 2 2 3
       c 1 1 2 2 2 3
       a 1 2 3 3 3 3 (cap)
       k 1 2 3 4 4 4
        */
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp2[i][j] = dp2[i - 1][j - 1] + 1;
                } else {
                    dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i][j - 1]);
                }
            }
        }
        System.out.println(dp2[n][m]);
        //print();
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                System.out.print(dp2[i][j] + " ");
            }
            //System.out.println("dp[" + i + "] : " + dp[i]);
            System.out.println();
        }
        System.out.println();
    }
}







