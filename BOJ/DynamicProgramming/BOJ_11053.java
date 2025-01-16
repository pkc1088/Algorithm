package BOJ.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;
public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i < N + 1; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        //  1  2  3  4  5  6  7  8  9
        //  40 20 50 25 1  2  3  4  5
        for(int i = 1; i < N + 1; i++) {
            System.out.println("i : " + i);
            dp[i] = 1;
            // 1 ~ i 원소들 탐색
            for(int j = 1; j < i + 1; j++) {
                // j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
                if(seq[j] < seq[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;	// j번째 원소의 +1 값이 i번째 dp가 된다.
                    System.out.println("dp["+i+"] = dp[" + j + "] + 1 = " + dp[i]);
                }
            }
        }

        //seq j - seq i
        // 최댓값(최대 길이) 탐색
        int max = -1;
        for(int i = 1; i < N + 1; i++) {
            max = dp[i] > max ? dp[i] : max;
        }
        System.out.println(max);

    }

}
//public class Main {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st;
//    static ArrayList<Integer> list1, list2;
//    static int[][] ddp;
//    static int[][] darr;
//    static int[] dp, temp;
//    static int[] arr;
//    static boolean[][] visited;
//    static int n, a, b, c, ans, cnt = 0, len = 0;
//
//    public static void main(String[] args) throws IOException {
//        n = Integer.parseInt(br.readLine());
//        arr = new int[n + 1];
//        dp = new int[n + 1];
//        ddp = new int[n + 1][n + 1];
//        temp = new int[n + 1];
//        st = new StringTokenizer(br.readLine(), " ");
//        for (int i = 1; i < n + 1; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        // dp[i] = y : i번 째까지 누적된 가장 긴 length y. 이때 i를 반드시 포함
//        // 10 20 10 30 *20* 50
//        // 1  2  1  3   2   4
//        // 1  2 0+1 2+1 1+1 3+1 (temp)
//        // 1  2  2  3   3   4   (final)
//        if(n == 1) {
//            System.out.println(1);
//            System.exit(0);
//        } if (n == 2) {
//            if(arr[1] < arr[2]) {
//                System.out.println(2);
//                System.exit(0);
//            } else {
//                System.out.println(1);
//                System.exit(0);
//            }
//        }
//        dp[0] = temp[0] = 0; dp[1] = temp[1] = 1;
//        if(arr[1] < arr[2]) dp[2] = temp[2] = 2;
//        else {
//            dp[2] = 1;
//            temp[2] = 1;
//        }
//   //index  1   2   3   4   5   6   7   8   9
//        //  40  20  50  25  1   2   3   4   5
//        //  1   0+1 2   1+1 0+1 2   3   4   5      temp
//        //  1   1   2   2   2   2   3   4   5      dp
//        for (int i = 3; i < n + 1; i++) {
//            if (arr[i - 1] < arr[i]) {
//                dp[i] = dp[i - 1] + 1;
//                temp[i] = temp[i - 1] + 1;
//                //System.out.println("dp[" + i + "] = dp[" + (i - 1) + "] + 1 -> " + dp[i]);
//            } else {
//                // 예를 들어 20이라면 20보다 작은 애까지 찾아간 뒤 그 인덱스 dp[x]에 자기자신 +1한 값을 dp[i]로 저장 즉 dp[i] = dp[x] + 1;
//                for (int j = i - 1; j >= 0; j--) {
//                    if(j == 0) {
//                        //System.out.println("search i : " + i + ", j : " + j);
//                        temp[i] = 1; //dp[i - 1];
//                        dp[i] = dp[i - 1];
//                    }
//                    else if(arr[j] < arr[i]) {
//                        System.out.println("found : " + arr[j] +" is smaller than " + arr[i]);
//                        //dp[i] = dp[j] + 1;
//                        temp[i] = temp[j] + 1;
//                        dp[i] = Math.max(temp[i], dp[i - 1]);
//                        break;
//                        //dp[i] = Math.max(dp[i - 1], dp[j] + 1); //Math.max(dp[i - 1], )
//                    }
//
//                }
//            }
//        }
//        //print();
//        ans = ddp[1][n];
//        for (int i = 2; i < n + 1; i++) {
//            if(ans < ddp[i][n]) ans = ddp[i][n];
//        }
//        System.out.println(ans);
//        //System.out.println("temp : " + temp[n] + ", dp : " + dp[n]);
//    }
//    public static void print() {
//        for (int i = 1; i < n + 1; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        System.out.println();
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                System.out.print(ddp[i][j] + " ");
//            }
//            System.out.println();
//            //System.out.println("temp[" + i + "] : " + temp[i] + ", dp[" + i + "] : " + dp[i]);
//        }
//    }
//}
////                    System.out.println("search i : " + i + ", j : " + j);
////                        System.out.println("arr[" + j + "] < arr[" + i + "]");











