import java.io.*;
import java.util.*;

public class BOJ_11725 {
    public static int n, start = 1;
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];

        for(int i=0; i<=n+1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=1; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs();
        for(int i=2; i<parents.length; i++)
            System.out.println(parents[i]);
    }

    private static void bfs() {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);
        parents[start] = 1;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int item : list.get(node)) {
                if(parents[item] == 0) {
                    parents[item] = node;
                    queue.offer(item);
                }
            }
        }
    }

}
