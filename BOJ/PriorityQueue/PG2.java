package BOJ.PriorityQueue;

// "기능개발"

import java.util.*;

class PG2 {
    public int[] solution(int[] pgr, int[] sp) {
        int[] ans = {};
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int after = 0, realTime = 1;
        // 7 3 9
        for(int work = 0; work < pgr.length; work++) {
            int i = 1;
            for(; i <= 100; i++) {
                pgr[work] += sp[work];
                if(pgr[work] >= 100) {
                    break;
                }
            }
            q.offer(i);
        }
        System.out.println(q);

        int release = q.poll();
        int batch = 1;

        while(!q.isEmpty()) {
            int check = q.poll();
            if(release >= check) {
                batch++;
            } else {
                list.add(batch);
                batch = 1;
                release = check;
            }
        }
        if(batch >= 1) list.add(batch);

        return list.stream().mapToInt(i->i).toArray();
    }
}