package BOJ.Greedy;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1931 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> list, list1, list2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2;
    static int[] dp, brr;
    static long[][] arr;
    static int n, m, k, a, b, c, ans = -1, cnt = 0, max = Integer.MIN_VALUE;
    static String str1, str2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        arr = new long[n + 1][2 + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][1] = Long.parseLong(st.nextToken());    //start
            arr[i][2] = Long.parseLong(st.nextToken());   //end
        }

        Arrays.sort(arr, (o1, o2) -> {
            // 종료시간이 같을 경우 시작시간이 빠른 순으로 정렬
            if (o1[2] == o2[2]) {
                return Long.compare(o1[1], o2[1]); // 시작시간 비교
            }
            return Long.compare(o1[2], o2[2]); // 종료시간 비교
        });

        long end = arr[1][2];
        cnt++;
        if(n == 1) {
            System.out.println(cnt);
            System.exit(1);
        }
        for (int i = 2; i < n + 1; i++) {
            if(arr[i][1] >= end) {
                end = arr[i][2];
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void print() {
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
            }
            System.out.println();
        }
        System.out.println();
    }
}
