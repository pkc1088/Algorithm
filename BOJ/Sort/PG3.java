package BOJ.Sort;

// "H-Index"

import java.util.*;
import java.util.stream.*;
class PG3 {
    public int solution(int[] arr) {

        Integer[] cts = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(cts, Comparator.reverseOrder());
        //Arrays.sort(cts, Comparator.reverseOrder());
        // 10 10 6 5 5 3 1 0
        // 10 10 0 0 0 0 0 0
        // 10 10 1 1 1 0 0 0
        // h = i+1

        int temp = 0, temp2 =  -1, h = 0;
        if(cts[0] == 0) return 0;
        if(cts[0] == 1) return 1;

        for(int i = 0; i < cts.length; i++) {
            if(cts[i] >= i + 1) {
                h = i + 1;
            }
            if(cts[i] < i + 1) {
                h = Math.max(h, cts[i]);

                System.out.println("h: " + h);
                //return h;
            }
        }

        return h;
    }
}