import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());

        for (int i = 2;i*i <= M;i++)
        {
            while (M%i == 0)
            {
                bw.write(String.valueOf(i));
                bw.newLine();
                M /= i;
            }
        }

        if(M>1)
            bw.write(String.valueOf(M));
        /*
        for (int i = 2; i <= M; i++) {
            while(true) {
                if(M%i==0) {
                    M = M/i;
                    bw.write(String.valueOf(i));
                    bw.newLine();
                }
                else
                    break;
            }
        }*/

        bw.flush();
        bw.close();
    }
}
