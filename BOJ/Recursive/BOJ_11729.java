package BOJ.Recursive;

import java.io.*;

public class BOJ_11729 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        bw.write((int) (Math.pow(2, N) - 1) + "\n");
        Hanoi(N, 1, 2, 3);
        bw.flush();
        bw.close();
    }

    public static void Hanoi(int N, int start, int mid, int to) throws IOException {
        if (N == 1) {
            bw.write(start + " " + to + "\n");
            return;
        }
        // A -> C로 옮긴다고 가정할 떄,
        // STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
        Hanoi(N - 1, start, to, mid);
        // STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
        bw.write(start + " " + to + "\n");
        // STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
        Hanoi(N - 1, mid, start, to);

    }
}