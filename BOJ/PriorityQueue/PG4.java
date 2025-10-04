package BOJ.PriorityQueue;

// "프로세스"

import java.util.*;

class PG4 {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();

        // 작업 배열을 (인덱스, 중요도) 형태로 큐에 저장
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }

        int count = 0; // 처리된 작업 수

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigher = false;

            // 큐 안에 더 높은 중요도가 있는지 체크
            for (int[] job : queue) {
                if (job[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                // 더 높은 중요도가 있으면 뒤로 보내기
                queue.offer(current);
            } else {
                // 처리
                count++;
                if (current[0] == location) {
                    return count; // 찾고자 하는 작업이면 순서 반환
                }
            }
        }
        return count;
    }
}
/*
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue p = new PriorityQueue<>(Collections.reverseOrder());;

        for(int i=0; i<priorities.length; i++){
            p.add(priorities[i]);
            System.out.println(p);
        }
        System.out.println(p);

        while(!p.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)p.peek()){
                    if(i == location){
                        return answer;
                    }
                    p.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
}
 */