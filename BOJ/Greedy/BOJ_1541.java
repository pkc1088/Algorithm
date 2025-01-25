package BOJ.Greedy;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1541 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2;
    static int[] dp, brr, arr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0, max = Integer.MIN_VALUE;
    static String str, str1, str2;

    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine(), " ");
//        n = Integer.parseInt(st.nextToken());
//        arr = new int[n + 1];
//        dp = new int[n + 1];
        st = new StringTokenizer(br.readLine(), "-");
        n = st.countTokens();
        String[] srr = new String[n];
        int i = 0;
        while(st.hasMoreTokens()) {
            srr[i++] = st.nextToken();
        }

        int tok = 0;
        st = new StringTokenizer(srr[0], "+");
        m = st.countTokens();
        for (int l = 0; l < m; l++) {
            tok += Integer.parseInt(st.nextToken());
        }
        ans = tok;
        //System.out.println("base : " + ans);

        for (int j = 1; j < n; j++) {
            tok = 0;
            tk = new StringTokenizer(srr[j], "+");
            k = tk.countTokens();
            for (int l = 0; l < k; l++) {
                tok += Integer.parseInt(tk.nextToken());
            }
            //System.out.println("srr["+j+"] sum : " + tok);
            ans -= tok;
        }
        System.out.println(ans);
        /*
        1 - (3 + 5) - (4 + 10)
        = 1 - 8 - 14 = -21
        즉 -(a+b) 꼴로 많이 만들어야한다.
        */
    }

    public static void print() {
        for (int i = 1; i < n + 1; i++) {
        }
        System.out.println();
    }
}

