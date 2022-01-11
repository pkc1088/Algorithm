import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(M-N));
        bw.flush();
        bw.close();
    }
}
