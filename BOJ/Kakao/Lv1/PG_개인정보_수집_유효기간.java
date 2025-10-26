package BOJ.Kakao.Lv1;

import java.util.*;
import java.util.stream.*;

class PG_개인정보_수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] prv) {
        // 28 x 12 = 336 -> 335 까지 가능
        List<Integer> list = new ArrayList<>();
        //String[][] info = new String[prv.length][2];
        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < terms.length; i++) {
            String[] dto = terms[i].split(" ");
            map.put(dto[0], dto[1]);
        }

        for(int i = 0; i < prv.length; i++) {
            String[] dto = prv[i].split(" ");
            int valid_due = Integer.parseInt(map.get(dto[1]));
            if(calDiff(today, dto[0]) >= 28 * valid_due) {
                list.add(i + 1);
            }
        }


        return list.stream().mapToInt(i->i).toArray();
    }

    public int calDiff(String today, String date) {
        // System.out.println(today + " : " + date);
        // 항상 today > date 임
        int diff;
        String[] cal = today.split("[.]");
        int year = Integer.parseInt(cal[0]);
        int month = Integer.parseInt(cal[1]);
        int day = Integer.parseInt(cal[2]);
        diff = year * 336 + month * 28 + day;

        String[] cals = date.split("[.]");
        year = Integer.parseInt(cals[0]);
        month = Integer.parseInt(cals[1]);
        day = Integer.parseInt(cals[2]);
        diff -= year * 336 + month * 28 + day;

        return diff;
    }

}