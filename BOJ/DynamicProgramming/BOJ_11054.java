package BOJ.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11054 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringTokenizer st;
    static StringBuilder sb;
    static List<Integer> list = new ArrayList<>();
    static int[] team;
    static boolean[] visit;
    static int[] arr, brr, dp, dp2;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n, m, e, v;
    static int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        brr = new int[n];
        dp = new int[n];
        dp2 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = brr[n - i - 1] = num;
            dp[i] = dp2[i] = 1; // 최소 자기 자신 길이 1
        }
//        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
//        System.out.println(Arrays.stream(brr).boxed().collect(Collectors.toList()));

        int max = 1, max2 = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                if (brr[j] < brr[i]) {
                    dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
                }
            }
            max = Math.max(max, dp[i]);
            max2 = Math.max(max2, dp2[i]);
        }

//        for (int i = 0; i < n; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();
//        // 1 2 5 4 3 4 1 2 5 1
//        // 1 2 3 3 3 4 1
//        for (int i = 0; i < n; i++) {
//            System.out.print(dp2[i] + " ");
//        }

        int ans = -1;
        for (int i = 0; i < n; i++) { // n = 10 / 6        i =  7 / 2
            ans = Math.max(ans, dp[i] + dp2[n - i - 1] - 1);
        }

        System.out.println(ans);
    }

}
/*
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
*/






