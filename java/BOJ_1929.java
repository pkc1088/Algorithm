import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class BOJ_1929 {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        prime = new boolean[N + 1];
        get_prime();

        StringBuilder sb = new StringBuilder();

        for(int i = M; i <= N; i++) {
            // false = ¼Ò¼ö
            if(!prime[i])
                sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    public static void get_prime() {
        // true = ¼Ò¼ö¾Æ´Ô , false = ¼Ò¼ö
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i])
                continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
