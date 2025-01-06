import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " +");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int index = 0, cnt = 0, Kleft = K;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(Kleft>=arr[i])
                index++;
        }

        while (Kleft!=0) {
            --index;
            cnt += Kleft/arr[index];
            Kleft = Kleft%arr[index];
            index = 0;
            for (int i = 0; i < N; i++) {
                if(Kleft>=arr[i])
                    index++;
            }
        }
        System.out.println(cnt);
    }
}

