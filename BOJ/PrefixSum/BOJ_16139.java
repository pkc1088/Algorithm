package BOJ.PrefixSum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16139 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] alpa;
    static int n;
    static String str1;

    public static void main(String[] args) throws IOException {
        str1 = br.readLine();
        n = Integer.parseInt(br.readLine());
        alpa = new int[26 + 1][str1.length() + 1]; // row: 26 (a~z), column: 문자열 길이 + 1

        int idx;
        for (int i = 1; i < str1.length() + 1; i++) {
            idx = str1.charAt(i - 1) - 'a' + 1; // a~z를 1~26으로 매핑
            for (int j = 1; j < 26 + 1; j++) {
                if (j == idx) {
                    alpa[j][i] = alpa[j][i - 1] + 1;
                } else {
                    alpa[j][i] = alpa[j][i - 1];
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String c = st.nextToken();
            idx = c.charAt(0) - 'a' + 1;
            int from = Integer.parseInt(st.nextToken()) + 1; // 0-based -> 1-based
            int to = Integer.parseInt(st.nextToken()) + 1;   // 0-based -> 1-based
            // 결과 계산 및 출력
            bw.write(alpa[idx][to] - alpa[idx][from - 1] + "\n");
        }
        bw.flush();
    }
}

//package BOJ;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.StringTokenizer;
//
//public class Main {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st;
//    static ArrayList<Integer> list1, list2;
//    static boolean[][] visit2;
//    static boolean[] visit;
//    static int[][] arr2, brr2, dp2, alpa;
//    static int[] arr, brr, dp;
//    static int n, m, k, a, b, c, ans = -1, cnt = 0, max = Integer.MIN_VALUE;
//    static String str1, str2;
//
//    public static void main(String[] args) throws IOException {
//        str1 = br.readLine();
//        n = Integer.parseInt(br.readLine());
//        alpa = new int[str1.length() + 1][26 + 1]; // 2000 26
//        // a~z = 1 ~ 26
//        int idx;
//        for (int i = 1; i < str1.length() + 1; i++) {
//            idx = (int) str1.charAt(i - 1) - 96;
//            //System.out.println("i : " + i + ", idx : " + idx);
//            for (int j = 1; j < 26 + 1; j++) {
//                if(j == idx) {
//                    alpa[i][j] = alpa[i - 1][j] + 1;
//                } else {
//                    alpa[i][j] = alpa[i - 1][j];
//                }
//            }
//        }
//        //print();
//        /*1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9
//          a b c d e f g h i j k l m n o p q r s ...
//        0 0 0 0 0 0 0 0                       0 ...
//        1 0 0 0 0 0 0 0                       1
//        2 0 0 0 0 1 0 0                       1 ...
//        3
//        4
//
//         */
//        // a 6 10
//        for (int i = 1; i < n + 1; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            String c = st.nextToken();
//            idx = (int) c.charAt(0) - 96;
//            int from = Integer.parseInt(st.nextToken()) + 1; // 0 -> 1
//            int to = Integer.parseInt(st.nextToken()) + 1; // 5 -> 6
//            // 1 2 3 4 5 6 7
//            // s e u n g j a
//            // len = 7
//            bw.write(alpa[to][idx] - alpa[from - 1][idx] + "\n");
//            bw.flush();
//        }
//    }
//
//    public static void print() {
//        for (int i = 0; i < str1.length() + 1; i++) {
//            for (int j = 0; j < 26 + 1; j++) {
//                System.out.print(alpa[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//}
//
//
//
//
//
//
