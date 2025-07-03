package BOJ.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11054 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list1, list2;
    static int[][] dpp;
    static int[] dp, dp2;
    //static int[] arr, arr2;
    static boolean[][] visited;
    static int n, a, b, c, ans = -1, cnt = 0;
    static int bt = -1, F_max = -1, F_min = 10000;
    static ArrayList<Integer> bt_idx;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] arr2 = new int[n + 1];
        dp = new int[n + 1];
        //dp2 = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr2[n - i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            int f1 = LCS_Forward(i, arr);
            int b1 = LCS_Forward(n - i + 1, arr2);
            //int b1 = LCS_Backward(n - i + 1);
            if(ans < f1 + b1 - 1)
                ans = f1 + b1 - 1;
        }
        System.out.println(ans);
    }
    // 꼭 최대값이 바이토닉의 기준점이 되어야하는게 아니다 (반례)
    //7
    //1 6 7 2 3 4 5
    public static int LCS_Forward(int index, int[] array) {
        //dp = new int[n + 1];
        for(int i = 1; i < index + 1; i++) {
            dp[i] = 1;
            for(int j = 1; j < i + 1; j++) {
                if(array[j] < array[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp[index];
    }
    public static int LCS_Backward(int index, int[] arr2) {
        //dp2 = new int[n + 1];
        for(int i = 1; i < index + 1; i++) {
            dp2[i] = 1;
            for(int j = 1; j < i + 1; j++) {
                if(arr2[j] < arr2[i] && dp2[j] + 1 > dp2[i]) {
                    dp2[i] = dp2[j] + 1;
                    //System.out.println("dp["+i+"] = dp[" + j + "] + 1 = " + dp[i]);
                }
            }
        }
        return dp2[index];
    }
//    public static void print(int fwd) {
//        if(fwd == 1)
//            for (int i = 1; i < n + 1; i++) {
//                System.out.println("dp[" + i + "] : " + dp[i]);
//            }
//        else if(fwd == 2)
//            for (int i = 1; i < n + 1; i++) {
//                System.out.println("dp2[" + i + "] : " + dp2[i]);
//            }
//        else
//            for (int i = 1; i < n + 1; i++) {
//                System.out.print(arr[i] + " ");
//            }
//        System.out.println();
//    }
}







