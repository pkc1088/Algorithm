import java.io.*;
import java.util.*;

public class NDB_3_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][]card = new int[N][M];
        int []ans = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(card[i]);
            ans[i]=card[i][0];
        }
        Arrays.sort(ans);
        System.out.println(ans[N-1]);
    }
}
