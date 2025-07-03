import java.io.*;
import java.util.Arrays;

public class BOJ_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] freq = new int[8001];

        for (int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(br.readLine());
            sum += arr[i];
            freq[4000+arr[i]]++;
        }
        Arrays.sort(arr);

        int ansIndex=0;
        boolean IsSec = false;
        for (int i = 1; i < freq.length; i++) {
            if(freq[i]>freq[ansIndex]) {
                ansIndex = i;
                IsSec = false;
            }

            else if(freq[i]==freq[ansIndex] && !IsSec) {
                ansIndex = i;
                IsSec = true;
            }
        }

        bw.write(String.valueOf((int)Math.round((double)sum / N)));
        bw.newLine();
        bw.write(String.valueOf(arr[N/2]));
        bw.newLine();
        bw.write(String.valueOf(ansIndex-4000));
        bw.newLine();
        bw.write(String.valueOf(arr[N-1]-arr[0]));

        bw.flush();
        bw.close();
    }
}
