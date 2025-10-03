package BOJ.Hash;

// "완주하지 못한 선수"

import java.util.*;
import java.io.*;
public class PG1 {
    public String solution(String[] p, String[] c) {

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < p.length; i++) {
            if (map.containsKey(p[i])) {
                map.replace(p[i], map.get(p[i]) + 1);
            } else {
                map.put(p[i], 1);
            }
        }

        for(int i = 0; i < c.length; i++) {
            if(map.get(c[i]) == 1) {
                map.remove(c[i]);
            } else {
                map.replace(c[i], map.get(c[i]) - 1);
            }
        }

        String str = map.keySet().toString();
        str = str.substring(1, str.length() - 1);


        return str;
    }
}
/*

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // 참가자 명단 카운트
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주자 명단 빼주기
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // 값이 1로 남은 사람이 완주하지 못한 선수
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }
        return ""; // 기본 리턴 (논리상 도달하지 않음)
    }
}
 */