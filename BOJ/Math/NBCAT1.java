package BOJ.Math;

class NBCAT1 {
    public int solution(String t, String p) {
        int answer = 0, flag = 0;

        for(int i = 0; i <= t.length() - p.length(); i++) { // 7 - 3
            String tsub = t.substring(i, i + p.length());
            Long tlong = Long.parseLong(tsub);
            Long plong = Long.parseLong(p);
            if(tlong <= plong) answer++;
        }
        return answer;
    }
}