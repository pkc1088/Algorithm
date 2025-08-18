package BOJ.Math;

import java.util.*;
import java.io.*;
class NBCAT2 {
    public int[] solution(String my_string) {
        int len = my_string.length();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < len; i++) {
            char check = my_string.charAt(i);
            if('0' <= check && check <= '9')
                ans.add(check - '0');
        }
        Collections.sort(ans);

        int answer[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}