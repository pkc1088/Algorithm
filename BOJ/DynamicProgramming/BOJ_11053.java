package BOJ.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;
public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i < N + 1; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        //  1  2  3  4  5  6  7  8  9
        //  40 20 50 25 1  2  3  4  5
        for(int i = 1; i < N + 1; i++) {
            System.out.println("i : " + i);
            dp[i] = 1;
            // 1 ~ i ���ҵ� Ž��
            for(int j = 1; j < i + 1; j++) {
                // j��° ���Ұ� i��° ���Һ��� �����鼭 i��° dp�� j��° dp+1 ������ �������
                if(seq[j] < seq[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;	// j��° ������ +1 ���� i��° dp�� �ȴ�.
                    //System.out.println("dp["+i+"] = dp[" + j + "] + 1 = " + dp[i]);
                }
            }
        }
        //seq j - seq i
        int max = -1;
        for(int i = 1; i < N + 1; i++) {
            System.out.print(dp[i] + " ");
            max = Math.max(dp[i], max);
        }
        System.out.println();
        System.out.println(max);

    }

}

/*
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // �ּ� �ڱ� �ڽ� ���� 1
        }

        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}

 */









