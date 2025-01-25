package BOJ.Greedy;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_13305 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2;
    static int[] dp, brr, arr;
    static Long[] city, road;
    static long ans = 0;
    static int n, m, k, a, b, c, cnt = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static String str, str1, str2;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        road = new Long[n];
        for (int i = 1; i < n; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        city = new Long[n]; // ���� ������ ��Ƽ�� ���� ���� �ʿ� ����.
        for (int i = 1; i < n; i++) {
            city[i] = Long.parseLong(st.nextToken());
        }
        Long trash = Long.parseLong(st.nextToken());
        // 1,000,000,000,000,000,000,000
        //     9,223,372,036,854,775,807
        Long cur_cost = Long.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if(cur_cost <= city[i]) {                //�� ���� ����
                ans += cur_cost * road[i];
            } else {                //city[i+1] �������� ����, i+1���� �� ���� �������� ���
                cur_cost = city[i];
                ans += cur_cost * road[i];
            }
        }
        System.out.println(ans);
        /*
        idx i���� �����ϴµ� ���� ���ð� ���� ���ú��� �θ� �ű������ ����.
        ���� ���� ���ð� ���� ���� ���ݺ��� ũ�� �����ϰ� ���� �� ���� �����Ѵ�.
         */
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
            System.out.println();
        }
        System.out.println();
    }
}
