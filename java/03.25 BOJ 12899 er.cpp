import java.io.*;
import java.util.*;


public class Main {
    static int[] arr, tree;
    static final int MAX = 2_000_001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        tree = new int[MAX*4];
        StringTokenizer st;
        while(q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(op == 1) {
                update(1, MAX, 1, x);
            }else {
                sb.append(query(1, MAX, 1, x)+"\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void update(int s, int e, int node, int idx) {
        if(idx < s || e < idx)
            return;

        tree[node] += 1;

        if(s == e)
            return;

        int mid = (s+e)/2;

        update(s, mid, node*2, idx);
        update(mid+1, e, node*2+1, idx);
    }

    static int query(int s, int e, int node, int k) {
        tree[node]-=1;

        if(s == e) {
            return s;
        }

        int mid = (s+e)/2;

        if(tree[2*node] < k) {
            // ���� �ڽ� ��忡 ���Ե� ������ ������ k������ ���� ��� ������ Ž��
            return query(mid+1, e, 2*node+1, k - tree[2*node]);
            // k-tree[2*node]��° ã��
        }else {
            // 2���� ���ų� ���� ���
            return query(s, mid, 2*node, k);
        }
    }

}
