import java.io.*;
import java.util.*;

public class BOJ_1697 {
    static int N;
    static int K;
    static int visited[] = new int[100001];
    // X-1, X+1
    // 2*X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
        int result = bfs(N);
        System.out.println(result);
    }

    private static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        int index = node;
        int n = 0;
        visited[index] = 1;
        while (!queue.isEmpty()) {
            n = queue.remove();
            if (n == K) {
                return visited[n]-1;
            }
            if (n-1>=0 && visited[n-1] == 0) {
                visited[n-1] = visited[n] + 1;
                queue.add(n-1);
            }
            if (n+1 <= 100000 && visited[n+1] == 0) {
                visited[n+1] = visited[n] + 1;
                queue.add(n+1);
            }
            if (2*n <= 100000 && visited[2*n] == 0) {
                visited[2*n] = visited[n] + 1;
                queue.add(2*n);
            }
        }
        return -1;
    }
}
