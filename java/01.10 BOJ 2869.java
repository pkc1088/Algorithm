import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int cnt = 0;

        if(a>=v) {
            cnt=1;
            bw.write(String.valueOf(cnt));
            bw.flush();
            bw.close();
            System.exit(0);
        }

        cnt=(v-a)/(a-b);
        if((v-a)%(a-b) == 0)
            cnt+=1;
        else if((v-a)%(a-b) < a)
            cnt+=2;

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
/*
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		int day = (length - down) / (up - down);
		if ((length - down) % (up - down) != 0)
			day++;

 */
