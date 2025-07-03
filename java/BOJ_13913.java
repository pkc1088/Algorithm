import java.io.*;
import java.util.*;
public class BOJ_13913 {
    static int N;
    static int K;
    static int[] dp = new int[100001];
    static int[] parent = new int[100001];
    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
        int result = bfs(N);
        System.out.println(result);


        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int idx = K;

        while (idx != N) {
            stack.push(idx);
            idx = parent[idx];
        }
        stack.push(idx);

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }

    private static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        int index = node;
        dp[index] = 1;
        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (n == K) {
                return dp[n]-1;
            }
            if (n-1>=0 && dp[n-1] == 0) {
                dp[n-1] = dp[n] + 1;
                parent[n - 1] = n;
                queue.add(n-1);
            }
            if (n+1 <= 100000 && dp[n+1] == 0) {
                dp[n+1] = dp[n] + 1;
                parent[n + 1] = n;
                queue.add(n+1);
            }
            if (2*n <= 100000 && dp[2*n] == 0) {
                dp[2*n] = dp[n] + 1;
                parent[n * 2] = n;
                queue.add(2*n);
            }
        }
        return -1;
    }
}

