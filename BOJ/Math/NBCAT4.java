package BOJ.Math;

import java.util.*;

class NBCAT4 {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] answer = new int[n];

        // 복사해서 정렬 (내림차순)
        int[] sorted = emergency.clone();
        Arrays.sort(sorted);

        // 각 응급도에 대해 순위 찾기
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (emergency[i] == sorted[j]) {
                    answer[i] = n - j; // 큰 수일수록 순위가 앞선다
                    break;
                }
            }
        }

        return answer;
    }
}

// import java.util.*;
// class NBCAT4 {
//     public int[] solution(int[] emergency) {

//         int[] answer = new int[emergency.length];
//         int[] temp = emergency.clone();
//         Arrays.sort(temp);

//         int cnt = 1;
//         for(int i = 0; i < answer.length; i++) {
//             for(int j = 0; j < emergency.length; j++) {
//                 if(temp[i] == emergency[j]) {
//                     answer[j] = emergency.length + 1 - cnt++;
//                     break;
//                 }
//             }
//         }

//         return answer;
//     }
// }