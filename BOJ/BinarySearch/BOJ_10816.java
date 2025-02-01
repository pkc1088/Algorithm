package BOJ.BinarySearch;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_10816 {
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
        n = Integer.parseInt(br.readLine());
        arr = new int[10000000 + 1];
        brr = new int[10000000 + 1];
        st = new StringTokenizer(br.readLine(), " ");
        int num;
        for (int i = 1; i < n + 1; i++) {
            num = Integer.parseInt(st.nextToken());
            if(num < 0)
                brr[num * -1]++;
            else
                arr[num]++;
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < m + 1; i++) {
            num = Integer.parseInt(st.nextToken());
            if(num < 0)
                bw.write(brr[num * -1] + " ");
            else
                bw.write(arr[num] + " ");
        }
        bw.flush();
    }
}
/*

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());

			// upperBound와 lowerBound의 차이 값을 구한다.
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		System.out.println(sb);
	}

	private static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;

		// lo가 hi랑 같아질 때 까지 반복
		while (lo < hi) {
		    int mid = (lo + hi) / 2;
			if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

 */