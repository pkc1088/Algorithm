import java.io.*;
import java.util.*;

public class BOJ_9345 {

    static int T;
    static int N, K;
    static int [] minTree;
    static int [] maxTree;
    static int MIN_VALUE = -1;
    static int MAX_VALUE = 100001;
    static int s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            s = 1;
            while (s < N) {
                s *= 2;
            }
            minTree = new int[s*2];
            maxTree = new int[s*2];

            Init();

            for (int k = 0; k < K; k++) {

                st = new StringTokenizer(br.readLine());
                int Q, A, B;
                Q = Integer.parseInt(st.nextToken());
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());

                // Q == 0 --> update
                if (Q == 0) {
                    int targetA = A+1;
                    int targetB = B+1;

                    int temp = minTree[s+targetA -1];
                    minTree[s+targetA -1] = minTree[s+targetB-1];
                    minTree[s+targetB-1] = temp;

                    temp = maxTree[s+targetA -1];
                    maxTree[s+targetA -1] = maxTree[s+targetB-1];
                    maxTree[s+targetB-1] = temp;

                    update(s+targetA-1);
                    update(s+targetB-1);

                }
                // Q == 1 --> query
                else if (Q == 1) {

                    int minValue = minQuery(1,s,1,A+1,B+1);
                    if(minValue != A) {
                        sb.append("NO\n");
                        continue;
                    }
                    int maxValue = maxQuery(1,s,1,A+1,B+1);
                    if(maxValue != B) {
                        sb.append("NO\n");
                        continue;
                    }
                    sb.append("YES\n");
                }

            }
        }

        System.out.println(sb);

    }

    static void Init() {
        // leaf채우기
        for (int i = 0; i < s; i++) {
            if(i < N) {
                minTree[s+i] = i;
                maxTree[s+i] = i;
            }
            else {
                minTree[s+i] = MAX_VALUE;
                maxTree[s+i] = MIN_VALUE;
            }
        }

        // parent 채우기
        for (int i = s - 1; i >= 1; i--) {
            minTree[i] = Math.min(minTree[i*2], minTree[i*2+1]);
            maxTree[i] = Math.max(maxTree[i*2], maxTree[i*2+1]);
        }

    }

    static int minQuery(int start, int end, int node, int left, int right) {
        // 값 사용x
        if (right < start || left > end)
            return MAX_VALUE;
            // 값 사용o
        else if (left <= start && right >= end) {
            return minTree[node];
        }
        // 자식에게 위임
        else {
            int mid = (start + end) / 2;
            return Math.min(minQuery(start, mid, node * 2, left, right)
                    ,minQuery(mid + 1, end, node * 2 + 1, left, right));
        }
    }

    static int maxQuery(int start, int end, int node, int left, int right) {

        // 값 사용x
        if (right < start || left > end)
            return MIN_VALUE;
            // 값 사용o
        else if (left <= start && right >= end) {
            return maxTree[node];
        }
        // 자식에게 위임
        else {
            int mid = (start + end) / 2;
            return Math.max(maxQuery(start, mid, node * 2, left, right)
                    ,maxQuery(mid + 1, end, node * 2 + 1, left, right));
        }
    }

    static void update(int node) {

        node = node / 2;

        while(node > 0) {

            maxTree[node] = Math.max(maxTree[node*2], maxTree[node*2+1]);
            minTree[node] = Math.min(minTree[node*2], minTree[node*2+1]);

            node /= 2;
        }
    }

}

