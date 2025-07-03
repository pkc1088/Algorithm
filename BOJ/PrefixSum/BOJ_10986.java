package BOJ.PrefixSum;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long result = 0;                            // M으로 나누어떨어지는 (i,j) 쌍의 개수
        long[] S = new long[N + 1];                 // 합배열
        long[] cnt = new long[M];                   // 같은 나머지의 인덱스를 카운트하는 배열

        // N개의 수 입력받으면서 누적합을 M으로 나눈 나머지를 배열 S에 저장한다.
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
            // 0~i까지의 합을 M으로 나눈 나머지가 0인 경우의 수 카운팅
            if(S[i] == 0) result++; // 이건 합배열 자체가 %M해서 0이 되는 경우 즉 [a, a] == 0
            // 나머지가 같은 인덱스의 수 카운팅
            cnt[(int) S[i]]++;
        }
        /*
        [a, b] = [1,b] - [1, a-1]
        => (sum(b) - sum(a-1)) % M == 0 을 구함
        => sum(b) % M - sum(a-1) % M == 0
        => sum(b) % M == sum(a-1) % M

        S[i] % M == 0 의미는 원본배열의 [1, i] 합이 M으로 나누어 떨어진다는 것
        S[j] % M == S[i-1] % M을 만족하는 [i, j]의 수를 구한다
        즉, j와 i-1 이 두 누적합의 나머지가 같다는건 그 둘 사이 구간 합은 M으로 나누어 떨어진다는 것을 의미
        즉 나머지 값이 같은 인덱스 중 2개를 뽑는 모든 경우의 수를 구하면 됨
         */
        // 이건 합배열끼리 %M이 같아지는 경우
        /*
        아래 for문의 핵심은 "나머지가 같은 두 인덱스를 뽑는 경우의 수"를 구하는 것입니다.
        예를 들어, 나머지가 2인 인덱스가 4개 있다고 하면, 가능한 쌍의 수는: 4C2 -> 4x3/2 = 6
        1,2,3,1,2의 배열의 경우 M으로 나눈 나머지가 1,0,0,1,0 나온다 위에서 s[j]%M과 S[i-1]%M이 같은 케이스를
        찾는거니 1,0,0,1,0 에서 첫번째와 네번쨰는 1로 같고 두번째,세번째,다섯번째는 0으로 같으니 해당 인덱스 뽑아 더하는
        것이니 조합이 맞다.
         */
        for (int i = 0; i < M; i++) {
            result += (cnt[i] * (cnt[i] - 1) / 2);
        }
        System.out.println(result);


    }
}
//
//public class Main {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st;
//    static ArrayList<Integer> list1, list2;
//    static boolean[][] visit2;
//    static boolean[] visit;
//    static int[][] dp2, brr2, dp2;
//    static int[] dp, brr, dp;
//    static int n, m, k, a, b, c, ans = -1, cnt = 0, max = Integer.MIN_VALUE;
//    static String str1, str2;
//
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine(), " ");
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        //dp = new int[n + 1];
//        dp = new int[n + 1]; // row: 26 (a~z), column: 문자열 길이 + 1
//        brr = new int[n + 1];
//        st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 1; i < n + 1; i++) {
//            brr[i] = dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
//            if(dp[i] % m == 0) cnt++;
//        }
//        /*
//        1 3 6 7 9
//        0 2 5 6 8
//        0 0 3 4 6
//        0 0 0 1 3
//        0 0 0 0 2
//
//        6같은 경우 dp[5]-dp[2] 여야하는데 이미 dp[2]는 앞에서 변경했음
//        dp[i][j - 1] + (dp[i-1][j-1] - dp[i-1][j])
//         */
////        for (int i = 2; i < n + 1; i++) {
////            dp[i - 1] = 0;
////            for (int j = i; j < n + 1; j++) {
////                dp[j] = dp[j - 1] + brr[j] - brr[j - 1];
////                if(dp[j] % m == 0) cnt++;
////            }
////            brr = Arrays.copyOf(dp, dp.length);
////        }
//        for (int i = 2; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                if ((dp[j] - dp[j - 1]) % m == 0) {
//                    cnt++;
//                }
//            }
//        }
//        bw.write(""+cnt);
//        bw.flush();
//        /*
//        1 2 (1~2) -> dp2[1][2]
//        1 2 3 (1~3) -> dp2[1][3]
//        1 2 3 1 2 (1~5) -> dp[1][5]
//        2 3 1 (2~4) -> dp[2][4]
//        3 (3~3) -> dp[3][3]
//        3 1 2 (3~5) -> dp[3][5]
//        1 2 (4~5) -> dp[4][5]
//        */
//        // 1,000,000 -> 2^6 x 2^6 = 2^12 = 1024 x 4 = 4GB
//    }
//
//    public static void print() {
//        for (int i = 1; i < n + 1; i++) {
//                System.out.print(dp[i] + " ");
//        }
//        System.out.println();
//    }
//}
