package BOJ.BinarySearch;


import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static String str, str1, str2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board, origin;
    static int[] dp, brr, arr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k + 1];

        long max = 0;

        // �Է°� ���ÿ� �ش� ������ ���̰� �ִ������� Ȯ���ϰ� max�� ����
        for (int i = 1; i < k + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // �ݵ�� max���� +1 ���̾�� �Ѵ�.
        max++;
        long min = 0;
        long mid = 0;
        while (min < max) {
            // ���� ������ �߰� ���̸� ���Ѵ�.
            mid = (max + min) / 2;
            long count = 0;
            // ������ �߰� ���̷� �߶� �� �� ���� ������������� ���Ѵ�.
            for (int i = 1; i < k + 1; i++) {
                count += (arr[i] / mid);
            }
            /*
             *  [upper bound ����]
             *
             *  mid���̷� �߶��� ���� ������ ������� �ϴ� ������ �������� �۴ٸ�
             *  �ڸ����� �ϴ� ���̸� ���̱� ���� �ִ� ���̸� ���δ�.
             *  �� �ܿ��� �ڸ����� �ϴ� ���̸� �÷��� �ϹǷ� �ּ� ���̸� �ø���.
             */
            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        // UpperBound�� ����� ��(min)�� -1�� �ִ� ���̰� �ȴ�.
        System.out.println(min - 1);
    }
}
