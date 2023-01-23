import java.io.*;
import java.util.*;

public class Main {
    public static int[][] start, done;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        start = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            start[i][0] = Integer.parseInt(st.nextToken());
            start[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(start, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });
        //Arrays.sort(start, Comparator.comparingInt(o1->o1[1]));   이건 불가 (첫 째자리 정렬 안돼서)
        int track = start[0][1], num = 1;
        for (int i = 1; i < n; i++) {
            System.out.println(start[i][0] + " " + start[i][1]);
            if(start[i][0] >= track) {
                num++;
                track = start[i][1];
            }
        }

        System.out.println(num);
    }
}
