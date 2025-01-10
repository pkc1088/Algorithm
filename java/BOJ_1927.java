import java.io.*;
import java.util.*;
public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(pq.peek() == null) {
                    pq.poll();
                    System.out.println(0);
                }
                else
                    System.out.println(pq.poll());
            }
            else {
                pq.add(x);
            }
        }

    }
}
