package BOJ.PriorityQueue;

// "´õ ¸Ê"

import java.util.PriorityQueue;

public class PG6 {
    public long solution(int[] sc, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long food : sc) pq.add(food);
        long cnt = 0L;

        while(!pq.isEmpty()) {
            long least = -1L, least2 = -1L;
            if(pq.peek() < k) {
                least = pq.poll();
                if(pq.isEmpty()) {
                    return -1;
                } else {
                    least2 = pq.poll();
                    pq.add(least + least2 * 2);
                    cnt++;
                }
            } else {
                return cnt;
            }
        }

        return -1L;
    }
}
