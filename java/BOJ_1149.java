import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class BOJ_1149 {
	
	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;
	
	static int[][] Cost;
	static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Cost = new int[N][3];
		DP = new int[N][3];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			Cost[i][Red] = Integer.parseInt(st.nextToken());
			Cost[i][Green] = Integer.parseInt(st.nextToken());
			Cost[i][Blue] = Integer.parseInt(st.nextToken());
		}
		
		// DP�� ù��° ��(��)�� �� �������� ù��° ������ �ʱ�ȭ
		DP[0][Red] = Cost[0][Red];
		DP[0][Green] = Cost[0][Green];
		DP[0][Blue] = Cost[0][Blue];
		
		
		System.out.println(Math.min(Paint_cost(N- 1, Red), Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue))));
	}
	
	static int Paint_cost(int N, int color) {
		
		// ���� Ž������ ���� �迭�̶��
		if(DP[N][color] == 0) {
			
			// color�� ���� ���� ���� ���� ���� �ٸ� ���� ���ȣ���Ͽ� �ּڰ��� ���� ���� ����� ���ؼ� DP�� �����Ѵ�
			if(color == Red) {
				DP[N][Red] = Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue)) + Cost[N][Red];
			}
			else if(color == Green) {
				DP[N][Green] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Blue)) + Cost[N][Green];
			}
			else {
				DP[N][Blue] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Green)) + Cost[N][Blue];
			}
			
		}
		
		return DP[N][color];
	}
}
/*
import java.io.*;
import java.util.*;

public class BOJ_1149 {
    static int N;
    static int col;
    static int [][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        cost = new int [N][3];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//  �� ������ Ʋ��, RGB�� ����� ������� �����ּ� �������� �� 3��� �� ���ؾ���
//        if(cost[0][0]<=cost[0][1] && cost[0][0]<=cost[0][2])
//            col = 0;
//        else if(cost[0][1]<=cost[0][0] && cost[0][1]<=cost[0][2])
//            col = 1;
//        else
//            col = 2;
//
        dp[0] = cost[0][col];

        for (int i = 1; i < N; i++) {
            dp[i] = dp[i-1] + Min_Exclusive(i);
        }

        System.out.println(dp[N-1]);
    }
    public static int Min_Exclusive(int i) {
        if(col==0) {
            if(cost[i][1] <= cost[i][2])
                col = 1;
            else
                col = 2;
            return cost[i][col];
        }
        else if(col==1) {
            if(cost[i][0] <= cost[i][2])
                col = 0;
            else
                col = 2;
            return cost[i][col];
        }
        else {
            if(cost[i][0] <= cost[i][1])
                col = 0;
            else
                col = 1;
            return cost[i][col];
        }
    }
}*/
