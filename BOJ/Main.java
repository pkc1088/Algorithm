package BOJ;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {solution();}

    static int[][] jobs = {{1, 3}, {2, 9}, {1, 4}, {5, 5}};

    public static int solution() {
        int[] cts = {3, 0, 6, 1, 5};

        Arrays.sort(cts);
        //Arrays.sort(cts, Comparator.reverseOrder());
        // 10 10 6 5 3 1 0

        for(int i = 0; i < cts.length; i++) {
            int h = cts[i];
            if(h <= i + 1) {
                return h;
            }
        }

        return 0;
    }

    public static class Job {
        int num;
        int request;
        int period;

        public Job(int num, int request, int period) {
            this.num = num;
            this.request = request;
            this.period = period;
        }
    }
}











