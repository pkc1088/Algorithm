package BOJ.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888 {
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
}
