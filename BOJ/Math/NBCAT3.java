package BOJ.Math;

import java.util.*;
class NBCAT3 {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> list1 = new ArrayList<>();
        for (int n : numbers) list1.add(n);

        Collections.sort(list1, Collections.reverseOrder());
        return list1.get(0) * list1.get(1);
    }
}