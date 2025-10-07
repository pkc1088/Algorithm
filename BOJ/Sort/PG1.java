package BOJ.Sort;

// "K¹ø¤Š¼ö"

import java.util.*;
import java.util.stream.*;
class PG1 {
    public int[] solution(int[] arr, int[][] cms) {

        List<Integer> list = new ArrayList<>();
        for(int[] cm : cms) {

            int[] temp = Arrays.copyOfRange(arr, cm[0] - 1, cm[1]);
            Arrays.sort(temp);

            System.out.println(Arrays.stream(temp).boxed().collect(Collectors.toList()));

            list.add(temp[cm[2] - 1]);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}