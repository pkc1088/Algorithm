import java.io.*;
import java.util.StringTokenizer;

public class LDS_LIS {
    static int N;
    static int[] seq;
    static int[] r_dp;
    static int[] l_dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        r_dp = new int[N];	// LIS
        l_dp = new int[N];	// LDS
        seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max = 0;
        for(int i = 0; i < N; i++) {
            if(max < r_dp[i] + l_dp[i]) {
                max = r_dp[i] + l_dp[i];
            }
        }

        System.out.println(max - 1);
    }

    static void LIS() {

        for(int i = 0; i < N; i++) {
            r_dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(seq[j] < seq[i] && r_dp[i] < r_dp[j] + 1) {
                    r_dp[i] = r_dp[j] + 1;	// j¹øÂ° ¿ø¼ÒÀÇ +1 °ªÀÌ i¹øÂ° dp°¡ µÈ´Ù.
                    //±×³É dp[i] = Math.max(dp[i], dp[i+1]); ÇØµµµÊ ifÁ¶°Ç¹® µÎ¹ø¤Š°Å ¾ø¾Ö°í 
                }
            }
        }
    }

    static void LDS() {
        for (int i = N - 1; i >= 0; i--) {
            l_dp[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (seq[j] < seq[i] && l_dp[i] < l_dp[j] + 1) {
                    l_dp[i] = l_dp[j] + 1;	// j¹ø¤Š ¿ø¼ÒÀÇ +1ÀÌ i¹ø¤Š dp°ªÀÌ µÊ
                }
            }
        }
    }

}
