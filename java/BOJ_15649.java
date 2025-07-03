import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15649 {
    public static int N;	// 정적변수로 변경
    public static int M;	// 정적변수로 변경
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정적변수 N과 M을 초기화해준다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];
        // 정적변수를 쓰면 되기 때문에 굳이 N과 M을 넘겨줄 필요 없다.
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}

/*
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " +");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int num = 0;
        for (int i = M; i >= 0; i--) {
            num += (int)Math.pow(10, i-1) * (M+1-i);
        }
        String strq = String.valueOf(num); //"1234"
        String[] strArr = new String[100];
        int t = 0;
        
        for (int i = 0; i != M-1; i++) {       //(M*(M-1))/2
            for (int k = i+1; k < strq.length(); k++) {

                for (int j = 0; j < strq.length(); j++) {
                    String first = strq.substring(0, 1);
                    String sub = strq.substring(1, strq.length());
                    strq = sub + first;
                    strArr[t] = strq;
                    t++;
                }
                char[] c = strq.toCharArray();
                char temp = c[i];
                c[i] = c[k];
                c[k] = temp;
                strq = new String(c);
            }
        }
        Arrays.sort(strArr, 0 , 24);
        for (int i = 0; strArr[i]!=null; i++) {
            bw.write(strArr[i]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}*/
