package BOJ.BackTracking;

import java.io.*;
import java.util.*;

public class BOJ_14888 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringTokenizer st;
    static StringBuilder sb;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visit;
    static int[] arr, op;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int numLen, m, e, v;
    static int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        numLen = Integer.parseInt(br.readLine());
        arr = new int[numLen + 1];
        visit = new boolean[5];
        op = new int[5];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < numLen + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < 5; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        if(numLen == 1) System.out.println(arr[1] + "\n" + arr[1]);

        dfs(arr[1], 1, op[1], op[2], op[3], op[4]);
        System.out.println(maxV + "\n" + minV);
    }

    public static void dfs(int value, int idx, int add, int mis, int mul, int div) {
        if(idx + 1 > numLen || (add == 0 && mis == 0 && mul == 0 && div == 0)) {
            if (maxV < value) maxV = value;
            if (minV > value) minV = value;
            return;
        }

        if(add > 0) {
            dfs(value + arr[idx + 1], idx + 1, add - 1, mis, mul, div);
        }
        if(mis > 0) {
            dfs(value - arr[idx + 1], idx + 1, add, mis - 1, mul, div);
        }
        if(mul > 0) {
            dfs(value * arr[idx + 1], idx + 1, add, mis, mul - 1, div);
        }
        if(div > 0) {
            dfs(value / arr[idx + 1], idx + 1, add, mis, mul, div - 1);
        }

    }
}

/*public class BOJ_14888 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] numarr, oparr;
    static int N;
    public static int MAX = Integer.MIN_VALUE;	// ÃÖ´ñ°ª
    public static int MIN = Integer.MAX_VALUE;	// ÃÖ¼Ú°ª
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numarr = new int[N];
        oparr = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numarr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) { // 2 1 1 1
            oparr[i] = Integer.parseInt(st.nextToken());
        }

        back(numarr[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }
    public static void back(int num, int idx) {
        if(idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(oparr[i] > 0) {
                oparr[i]--;
                switch(i) {
                    case 0 : back(num + numarr[idx], idx + 1); break;
                    case 1 : back(num - numarr[idx], idx + 1); break;
                    case 2 : back(num * numarr[idx], idx + 1); break;
                    case 3 : back(num / numarr[idx], idx + 1); break;
                }
                oparr[i]++;
            }
        }
    }
}*/

/*
package BOJ;

import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, cnt;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[]arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int pls = Integer.parseInt(st.nextToken());
        int mis = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());
        dfs(pls, mis, mul, div, arr[1], arr[1], 2);
        System.out.println(max + "\n" + min);
    }

    public static void dfs(int pls, int mis, int mul, int div, int vmax, int vmin, int idx) {
        if(pls == 0 && mis == 0 && mul == 0 && div == 0) {
            if(vmax > max) max = vmax;
            if(vmin < min) min = vmin;
            return;
        }

        if(pls > 0) {
            vmax += arr[idx];
            vmin += arr[idx];
            dfs(pls - 1, mis, mul, div, vmax, vmin, idx + 1);
            vmax -= arr[idx];
            vmin -= arr[idx];
        }
        if(mis > 0) {
            vmax -= arr[idx];
            vmin -= arr[idx];
            dfs(pls, mis - 1, mul, div, vmax, vmin,idx + 1);
            vmax += arr[idx];
            vmin += arr[idx];
        }
        if(mul > 0) {
            vmax *= arr[idx];
            vmin *= arr[idx];
            dfs(pls, mis, mul - 1, div, vmax, vmin,idx + 1);
            vmax /= arr[idx];
            vmin /= arr[idx];
        }
        if(div > 0) {
            vmax /= arr[idx];
            vmin /= arr[idx];
            dfs(pls, mis, mul, div - 1, vmax, vmin,idx + 1);
            vmax *= arr[idx];
            vmin *= arr[idx];
        }
    }


}

 */