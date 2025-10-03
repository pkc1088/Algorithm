package BOJ.Hash;

// "ÀÇ»ó"

import java.util.*;

public class PG4 {
    class Solution {
        public int solution(String[][] c) {
            HashMap<String, Integer> hm = new HashMap<>();

            for(int i = 0; i < c.length; i++) {
                int num = hm.getOrDefault(c[i][1], 0);
                hm.put(c[i][1], num + 1);
            }

            int ans = -1;
            int temp = 1;
            for(Map.Entry<String, Integer> str : hm.entrySet()) {
                temp *= str.getValue() + 1;
            }

            return ans + temp;
        }
    }
}
