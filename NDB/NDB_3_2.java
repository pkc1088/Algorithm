import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NDB_3_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = String.valueOf(st.nextToken());
        }
        int answer = 0; int result = 0;
        Arrays.sort(arr, Comparator.reverseOrder());
        if(Integer.parseInt(arr[0])==Integer.parseInt(arr[1])) {
            answer = M * Integer.parseInt(arr[0]);
        }
        else {
            for (int i = 0, j = 0; i < M; j++, i++) {
                if(j==K) {
                    answer += Integer.parseInt(arr[1]);
                    j = 0;
                }
                else {
                    answer += Integer.parseInt(arr[0]);
                }
            }/*
            int cnt = (M / (K + 1)) * K;
            cnt += M % (K + 1);
            result += cnt * Integer.parseInt(arr[0]);
            result += (M - cnt) * Integer.parseInt(arr[1]);*/
        }
        System.out.println(answer);
        //System.out.println(result);
    }
}
