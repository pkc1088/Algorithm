package BOJ.Sort;

// "가장 큰 수"

import java.util.*;
class PG2 {
    public String solution(int[] nums) {
        String[] ss = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        //  Arrays.sort(ss, Comparator.reverseOrder());
        // System.out.println(Arrays.stream(ss).collect(Collectors.toList()));
        Arrays.sort(ss, (a, b) -> Integer.parseInt(b+a) - Integer.parseInt(a+b));
            // Arrays.sort(ss, (a, b) -> (b + a).compareTo(a + b));
        if (ss[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        return sb.toString();
    }
}

