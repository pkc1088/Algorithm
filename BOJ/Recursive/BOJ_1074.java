package BOJ.Recursive;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1074 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        find(r,c,(int)Math.pow(2, N));
        System.out.println(cnt);
    }
    static void find(int x,int y, int size) {//7 5 8
        if(size == 1) return;
        if(x < size/2 && y < size/2) {	//왼쪽 위
            find(x, y, size/2);
        }
        else if(x < size/2 && size/2 <= y) {	//오른쪽 위
            cnt += (size*size/4)*1;
            find(x, y-size/2, size/2);
        }
        else if(x >= size/2 && size/2 > y) { //왼쪽 아래
            cnt+=(size*size/4)*2; // 4x4/4x2 = 8
            find(x-size/2, y, size/2); // 1, 1, 2
        }
        else {						//오른쪽 아래
            cnt+=(size*size/4)*3; // 8x8/4x3 = 48, 2x2/4x3 = 3
            find(x-size/2,y-size/2,size/2); // (3, 1, 4)
        }
    }
    public static void print(int N, int r, int c) throws IOException {
        int tp = (int)Math.pow(2, N);
        for (int i = 0; i < tp; i++) {
            for (int j = 0; j < tp; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}