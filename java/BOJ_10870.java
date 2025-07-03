import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10870 {
    static int[] arr = new int[22];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        arr[0] = 0; arr[1] = 1;
        pibo(2, arr);
        bw.write(String.valueOf(arr[N]));
        bw.flush();
        bw.close();
    }

    static void pibo(int n, int[] arr) {
        arr[n] = arr[n-1] + arr[n-2];
        if(n+1<22)
            pibo(n+1, arr);
        else
            return;

    }
}
