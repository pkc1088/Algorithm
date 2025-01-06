package BOJ_Quiz;

import java.io.*;
import java.util.Arrays;

public class BOJ_2447 {
    static char[][] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //n = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], '*');
        }

        int sc = n;
        removeMyself(sc);
        removeScale(sc);
        print();
    }

    public static void removeMyself(int sc) {
        for (int i = sc/3; i < sc/3*2; i ++) {
            for (int j = sc/3; j < sc/3*2; j ++) {
                arr[i][j] = ' ';
            }
        }
    }

    public static void removeScale(int sc) { //27
        for (int i = sc/9; i < n; i += sc/3) {
            for (int j = sc/9; j < n; j += sc/3) {
                for (int k = 0; k < sc/9; k++) {
                    for (int l = 0; l < sc/9; l++) {
                        arr[i+k][j+l] = ' ';
                    }
                }
            }
        }
        if(sc/3 > 1) {
            removeScale(sc/3);
        }
    }

    public static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
