import java.io.*;
import java.util.*;

public class NDB_16_5 {
    static int n;
    static int[] ugly = new int[1000]; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int i2 = 0, i3 = 0, i5 = 0;
        int next2 = 2, next3 = 3, next5 = 5;
        ugly[0] = 1; 
        for (int l = 1; l < n; l++) {
            // 가능한 곱셈 결과 중에서 가장 작은 수를 선택
            ugly[l] = Math.min(next2, Math.min(next3, next5));
            // 인덱스에 따라서 곱셈 결과를 증가
            if (ugly[l] == next2) {
                i2 += 1;
                next2 = ugly[i2] * 2;
            }
            if (ugly[l] == next3) {
                i3 += 1;
                next3 = ugly[i3] * 3;
            }
            if (ugly[l] == next5) {
                i5 += 1;
                next5 = ugly[i5] * 5;
            }
        }
        // n번째 못생긴 수를 출력
        System.out.println(ugly[n - 1]);
    }
}
