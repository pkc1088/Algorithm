//D[n][k] : n번째 숫자나사가 k번 왼쪽 회전한 상태
public class Main {
    public static int N;
    public static int[] a;
    public static int[] b;
    public static int[][] dp, Dir, Cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 3
        a = new int[10001];
        b = new int[10001];
        dp = new int[10001][10];
        Dir = new int[10001][10];
        Cost = new int[10001][10];

        String str = br.readLine();
        for (int i = 0; i < N; i++)
            a[i] = str.charAt(i) - '0'; // 6(1)2(2)3(3)
        str = br.readLine();
        for (int i = 0; i < N; i++)
            b[i] = str.charAt(i) - '0'; // 6(1)4(2)4(3)
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(func(0, N, 0));
        printloc(0, N, 0);
    }

    static void printloc(int idx, int n, int turn) {

        if (idx == n) return;

        int move = Dir[idx][turn] * Cost[idx][turn];

        if (move != 0) System.out.println(idx + 1 +" "+ move);
        if (Dir[idx][turn] > 0) printloc(idx + 1, n, (turn + move + 10) % 10);
        else printloc(idx + 1, n, turn);
    }

    public static int func(int idx, int n, int turn) {

        if (idx == n)
            return 0;

        int ret = dp[idx][turn];
        if (ret != -1)
            return ret;

        int cur = (a[idx] + turn)%10;

        //left
        int leftTurn = (b[idx] - cur + 10) % 10;
        int leftCostSum = func(idx + 1, n, (turn + leftTurn) % 10) + leftTurn;

        //right
        int rightTurn = (cur - b[idx] + 10) % 10;
        int rightCostSum = func(idx + 1, n, turn) + rightTurn;

        if (rightCostSum > leftCostSum) {
            ret = leftCostSum;
            Dir[idx][turn] = 1;
            Cost[idx][turn] = leftTurn;
        }
        else {
            ret = rightCostSum;
            Dir[idx][turn] = -1;
            Cost[idx][turn] = rightTurn;
        }

        return ret;
    }
}


#include <cstdio>
#include <cstring>
 
int D[10001][10];
 
int From[10001];
int To[10001];
 
int Dir[10001][10];
int Cost[10001][10];
 
int f(int idx, int n, int turn) {
 
    if (idx == n) return 0;
 
    int& ret = D[idx][turn];
    if (ret != -1) return ret;
 
    int cur = (From[idx] + turn)%10;
 
    //left
    int leftTurn = (To[idx] - cur + 10) % 10;
    int leftCostSum = f(idx + 1, n, (turn + leftTurn) % 10) + leftTurn;
 
    //right
    int rightTurn = (cur - To[idx] + 10) % 10;
    int rightCostSum = f(idx + 1, n, turn) + rightTurn;
 
    if (rightCostSum > leftCostSum) {
        ret = leftCostSum;
        Dir[idx][turn] = 1;
        Cost[idx][turn] = leftTurn;
    }
    else {
        ret = rightCostSum;
        Dir[idx][turn] = -1;
        Cost[idx][turn] = rightTurn;
    }
 
    return ret;
}
 
void print(int idx, int n, int turn) {
     
    if (idx == n) return;
 
    int move = Dir[idx][turn] * Cost[idx][turn];
 
    if (move != 0) printf("%d %d\n", idx + 1, move);
    if (Dir[idx][turn] > 0) print(idx + 1, n, (turn + move + 10) % 10);
    else print(idx + 1, n, turn);
}
 
int main() {
 
    int n;
    scanf("%d", &n);
 
    for (int i = 0; i < n; i++) scanf("%1d", &From[i]);
    for (int i = 0; i < n; i++) scanf("%1d", &To[i]);
 
    memset(D, -1, sizeof(D));
    printf("%d\n", f(0,n,0));
    print(0, n, 0);
 
    return 0;
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int start[] = new int[N + 1];
        int end[] = new int[N + 1];
        String input[] = br.readLine().split("");
        for (int n = 1; n <= N; ++n) {
            start[n] = Integer.parseInt(input[n - 1]);
        }
        input = br.readLine().split("");
        for (int n = 1; n <= N; ++n) {
            end[n] = Integer.parseInt(input[n - 1]);
        }
        int dp[][] = new int[N + 1][10];
        for (int i = 0; i < 10; ++i) {
            int pos = (start[1] + 10 + i) % 10;
            dp[1][i] = (pos + 10 - end[1]) % 10 + i;
        }
        for (int n = 2; n <= N; ++n) {
            for (int j = 0; j < 10; ++j) { // 현재 상태는 j번 돈 상태가 될 것인데
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 10; ++k) { // 내가 이번 턴에 k번을 돈 것이라면
                    int pastOffset = (10 - k + j) % 10;
                    int pos = (start[n] + j) % 10; // 현재 상태
                    min = Math.min(min, dp[n - 1][pastOffset] + k + ((pos + 10 - end[n]) % 10));
                }
                dp[n][j] = min;
            }
        }
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> choice = new ArrayList<>();
        int index = N;
        int currentOffset = 0;
        for (int i = 0; i < 10; ++i) {
            if (min > dp[N][i]) {
                min = dp[N][i];
                currentOffset = i;
            }
        }
        bw.write(Integer.toString(min) + "\n"); // 최소횟수 출력
        while (index > 0) { // 행동 찾기
            for (int k = 0; k < 10; ++k) { // 내가 이번 턴에 왼쪽 방향으로 k번을 돈 것이라면
                int pastOffset = (10 - k + currentOffset) % 10;
                int pos = (start[index] + currentOffset) % 10; // 현재 위치
                if (min == dp[index - 1][pastOffset] + k + ((pos + 10 - end[index]) % 10)) {
                    currentOffset = pastOffset;
                    if (k != 0)
                        choice.add(index * 10 + k);
                    if ((pos + 10 - end[index]) % 10 != 0)
                        choice.add(-1 * (index * 10 + (pos + 10 - end[index]) % 10));
                    min = dp[--index][pastOffset];
                    break;
                }
            }
        }
        for (int n = choice.size() - 1; n >= 0; --n) {
            int value = choice.get(n);
            if(value < 0){
                value *= -1;
                bw.write(Integer.toString(value / 10) + " -" + Integer.toString(value % 10) + "\n");
            } else {
                bw.write(Integer.toString(value / 10) + " " + Integer.toString(value % 10) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}



출처: https://jsg1504.tistory.com/41 [장화신은 고양이]
