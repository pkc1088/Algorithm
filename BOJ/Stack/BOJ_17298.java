package BOJ.Stack;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_17298 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static PriorityQueue<Long> pq;
    static String str, str1, str2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board, result;
    static int[] dp, brr, arr, crr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0, sum = 0, C = 0, real_idx = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++) {
            /*4 2 3
             * ������ ������� �����鼭 (������� �ؿ� push�� ���� �׳� push��)
             * ���� ���Ұ� ������ �� �� ���Ұ� ����Ű�� ���Һ��� ū ���
             * �ش� ������ ������ �� ���� stack�� ���Ҹ� pop�ϸ鼭
             * �ش� �ε����� ���� ���� ���ҷ� �ٲ��ش�.
             */
            while(!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                seq[stack.pop()] = seq[i];
            }
            stack.push(i);
        }
        /*
         * ������ ��� ���Ҹ� pop�ϸ鼭 �ش� �ε����� value��
         * -1�� �ʱ�ȭ�Ѵ�.
         * �� ���п� 4 2 3 Ȥ�� 9 3 6 ���� 4, 4���� ������, 4���� ������ ���� ũ���� 4���� ������
         * �� ���¸� ó���� �� �ְ� �ȴ�
         * �� 0~N ���� ���� ���µ��� stack�� �ο��ִٴ°� ��׸� �ٸ� ���� ó���� �� ���ٴ� ���̴�
         * �� ��׺��� ��ū���� ���ٴ� ���̴� -1�� ���ν����ִ°���
         */
        while(!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(seq[i]).append(' ');
        }
        System.out.println(sb);
    }

    public static void print(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
