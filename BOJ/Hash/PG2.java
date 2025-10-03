package BOJ.Hash;

// "ÆùÄÏ¸ó"

import java.util.*;
import java.io.*;
public class PG2 {
    public int solution(int[] nums) {

        int len = nums.length;

        Set<Integer> hs = new HashSet<>();

        for(int num : nums) {
            hs.add(num);
        }

        if(hs.size() <= len / 2) {
            return hs.size();
        } else {
            return len / 2;
        }

    }
}
