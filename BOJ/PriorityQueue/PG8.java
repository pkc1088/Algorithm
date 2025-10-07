package BOJ.PriorityQueue;

// "이중우선순위큐"
// positive, negative 로 해버리면 나중에 구분 불가함. maxpq, minpq가 맞다

import java.util.*;

public class PG8 {
    public int[] solution(String[] operations) {
        Queue<Integer> minpq = new PriorityQueue<>();
        Queue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            if (operation.startsWith("I ")) {
                int n = Integer.parseInt(operation.substring(2));
                minpq.offer(n);
                maxpq.offer(n);
            } else if (!minpq.isEmpty() && operation.equals("D -1")) {
                maxpq.remove(minpq.poll());
            } else if (!maxpq.isEmpty() && operation.equals("D 1")) {
                minpq.remove(maxpq.poll());
            }
        }

        if (minpq.isEmpty() && maxpq.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxpq.poll(), minpq.poll()};
    }
}


/*
public int[] solution(String[] op) {
        int[] ans = new int[2];
        List<Integer> list = new ArrayList<>();

        for (String s : op) {
            if (s.startsWith("I ")) {
                int num = Integer.parseInt(s.substring(2));
                list.add(num);
            } else if (s.equals("D 1")) {
                if (!list.isEmpty()) {
                    Collections.sort(list, Comparator.reverseOrder());
                    list.remove(list.get(0));
                }
            } else if (s.equals("D -1")) {
                if (!list.isEmpty()) {
                    Collections.sort(list);
                    list.remove(list.get(0));
                }
            }
        }

        if (list.isEmpty()) {
            ans[0] = ans[1] = 0;
        } else {
            Collections.sort(list);
            ans[0] = list.get(list.size() - 1);
            ans[1] = list.get(0);
        }

        return ans;
    }

 */