import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean first = true;
        int firstEle=-1, sum = 0;
        prime = new boolean[N + 1];
        get_prime();

        for(int i = M; i <= N; i++) {
            if (!prime[i]) {
                sum += i;
                if (first) {
                    firstEle = i;
                    first = false;
                }
            }
        }

        if(sum!=0) {
            bw.write(String.valueOf(sum));
            bw.newLine();
        }
        bw.write(String.valueOf(firstEle));
        bw.flush();
        bw.close();
    }

    public static void get_prime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i])
                continue;

            for(int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }
}

