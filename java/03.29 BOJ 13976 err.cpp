import java.util.*;
import java.io.*;
//https://goodteacher.tistory.com/151 영상시청
public class Main {
    public static long M = 1000000007;
    public static long N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());

        if(N % 2 != 0) {
            System.out.println(0);
        } else {
            long[] baseCase = {3, 1};
            if(N == 2) {
                System.out.println(3);
            } else {
                System.out.println(multiMatrix(getPower(new long[][]
                        {{4,-1}, {1,0}}, N/2 - 1), baseCase));
            }
        }
    }

    static long[][] getPower(long[][] matrix, long n) {
        if(n == 1) {
            return matrix;
        } else {
            if(n % 2 ==0) {
                long[][] part = getPower(matrix, n/2);
                return multiMatrix(part, part);
            } else {
                return multiMatrix(getPower(matrix, n - 1), matrix);
            }
        }
    }

    static long[][] multiMatrix(long[][] a, long[][] b) {
        long[][] multi = new long[2][2];
        multi[0][0] = getMod(a[0][0], b[0][0], a[0][1], b[1][0]);
        multi[0][1] = getMod(a[0][0], b[0][1], a[0][1], b[1][1]);
        multi[1][0] = getMod(a[1][0], b[0][0], a[1][1], b[1][0]);
        multi[1][1] = getMod(a[1][0], b[0][1], a[1][1], b[1][1]);
        return multi;
    }

    static long multiMatrix(long[][] a, long[] b) {
        return getMod(a[0][0], b[0], a[0][1], b[1]);
    }

    static long getMod(long a, long b, long c, long d) {
        return ((a * b % M + (c * d % M) + M) % M);
    }

}


