package BOJ.PriorityQueue;

// "���μ���"

import java.util.*;

class PG4 {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();

        // �۾� �迭�� (�ε���, �߿䵵) ���·� ť�� ����
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }

        int count = 0; // ó���� �۾� ��

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigher = false;

            // ť �ȿ� �� ���� �߿䵵�� �ִ��� üũ
            for (int[] job : queue) {
                if (job[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                // �� ���� �߿䵵�� ������ �ڷ� ������
                queue.offer(current);
            } else {
                // ó��
                count++;
                if (current[0] == location) {
                    return count; // ã���� �ϴ� �۾��̸� ���� ��ȯ
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