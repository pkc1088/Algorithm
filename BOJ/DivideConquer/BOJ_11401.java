package BOJ.DivideConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_11401 {

    final static long P = 1000000007;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        // 분자 N!
        long numer = factorial(N);

        // 분모 (K! * (N-K)!) mod p
        long denom = factorial(K) * factorial(N - K) % P;


        // N! * 분모의 역((K! * (N-K)!)
        System.out.println(numer * pow(denom, P - 2) % P);

    }

    public static long factorial(long N) {
        long fac = 1L;
        while(N > 1) {
            fac = (fac * N) % P;
            N--;
        }
        return fac;
    }

    // base : 밑 / expo : 지수
    // 거듭 제곱 <- 분할 정복 방식
    public static long pow(long base, long expo) {
        if(expo == 1) {
            return base % P;
        }

        long temp = pow(base, expo / 2);

        if(expo % 2 == 1) {
            return (temp * temp % P) * base % P;
        }
        return temp * temp % P;

    }
}