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
        long result = 0;                            // M���� ����������� (i,j) ���� ����
        long[] S = new long[N + 1];                 // �չ迭
        long[] cnt = new long[M];                   // ���� �������� �ε����� ī��Ʈ�ϴ� �迭

        // N���� �� �Է¹����鼭 �������� M���� ���� �������� �迭 S�� �����Ѵ�.
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
            // 0~i������ ���� M���� ���� �������� 0�� ����� �� ī����
            if(S[i] == 0) result++; // �̰� �չ迭 ��ü�� %M�ؼ� 0�� �Ǵ� ��� �� [a, a] == 0
            // �������� ���� �ε����� �� ī����
            cnt[(int) S[i]]++;
        }
        /*
        [a, b] = [1,b] - [1, a-1]
        => (sum(b) - sum(a-1)) % M == 0 �� ����
        => sum(b) % M - sum(a-1) % M == 0
        => sum(b) % M == sum(a-1) % M

        S[i] % M == 0 �ǹ̴� �����迭�� [1, i] ���� M���� ������ �������ٴ� ��
        S[j] % M == S[i-1] % M�� �����ϴ� [i, j]�� ���� ���Ѵ�
        ��, j�� i-1 �� �� �������� �������� ���ٴ°� �� �� ���� ���� ���� M���� ������ �������ٴ� ���� �ǹ�
        �� ������ ���� ���� �ε��� �� 2���� �̴� ��� ����� ���� ���ϸ� ��
         */
        // �̰� �չ迭���� %M�� �������� ���
        /*
        �Ʒ� for���� �ٽ��� "�������� ���� �� �ε����� �̴� ����� ��"�� ���ϴ� ���Դϴ�.
        ���� ���, �������� 2�� �ε����� 4�� �ִٰ� �ϸ�, ������ ���� ����: 4C2 -> 4x3/2 = 6
        1,2,3,1,2�� �迭�� ��� M���� ���� �������� 1,0,0,1,0 ���´� ������ s[j]%M�� S[i-1]%M�� ���� ���̽���
        ã�°Ŵ� 1,0,0,1,0 ���� ù��°�� �׹����� 1�� ���� �ι�°,����°,�ټ���°�� 0���� ������ �ش� �ε��� �̾� ���ϴ�
        ���̴� ������ �´�.
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
//        dp = new int[n + 1]; // row: 26 (a~z), column: ���ڿ� ���� + 1
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
//        6���� ��� dp[5]-dp[2] �����ϴµ� �̹� dp[2]�� �տ��� ��������
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
