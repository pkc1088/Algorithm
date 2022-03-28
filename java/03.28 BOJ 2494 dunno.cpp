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


출처: https://jsg1504.tistory.com/41 [장화신은 고양이]
