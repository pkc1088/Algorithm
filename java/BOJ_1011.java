import java.io.*;
import java.util.*;
public class BOJ_1011 {
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int movingDistance = 0;
            int xMovingCount = 0;
            int yMovingCount = 0;

            while(true) {
                movingDistance++;

                x += movingDistance;
                xMovingCount++; // x의 이동횟수

                if(x >= y) {
                    break;
                }

                y -= movingDistance;
                yMovingCount++; // y의
                if(y <= x) {
                    break;
                }

            }
            bw.write(String.valueOf(xMovingCount+yMovingCount));
            bw.newLine();
        }
        bw.flush();
    }
}
/* 시간초과
public class BOJ_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int sum = 0, sum2 = 0, cnt = 0;
            int len = end - start;
            for (int k=0; sum < len/2; k++, cnt++) {
                sum = (k*(k+1))/2;
            }
            int left = len - sum;
            for (int k = 0; sum2 < left; k++, cnt++) {
                sum2 = (k*(k+1))/2;
                if(sum2 >= left)
                    break;
            }
            cnt=cnt-1;
            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
    }
}*/
