package BOJ.Hash;

// "전화번호 목록"

import java.util.*;
import java.io.*;

public class PG3 {
    class Solution {
        public boolean solution(String[] pb) {
            Map<Integer, String> map = new HashMap<>();
            Set<String> hs = new HashSet<>();
            Arrays.sort(pb, (s1, s2) -> s1.length() - s2.length());
            int minLen = pb[0].length();

            for(String s : pb) {
                for(int i = minLen; i <= s.length(); i++) {

                    String toInsert = s.substring(0, i);

                    if(hs.contains(toInsert)) return false;

                }
                hs.add(s);
            }

            return true;
        }
    }
}
// class Solution {
//     public boolean solution(String[] phone_book) {
//         // 1. 정렬
//         Arrays.sort(phone_book);

//         // 2. 인접한 번호만 확인
//         for (int i = 0; i < phone_book.length - 1; i++) {
//             if (phone_book[i + 1].startsWith(phone_book[i])) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }