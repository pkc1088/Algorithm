import java.io.*;
import java.util.*;

public class BOJ_16975 {
    private static int[] arr;
    private static long[] sumtree;
    //arr을 범위스캔하면 시간초과 됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        sumtree = new long[4 * N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            char q = st.nextToken().charAt(0);
            if (q == '1') {
                int u = Integer.parseInt(st.nextToken()),
                        v = Integer.parseInt(st.nextToken()),
                        k = Integer.parseInt(st.nextToken());
                update(1, N, 1, u, k);
                update(1, N, 1, v + 1, -k);
            } else {
                int v = Integer.parseInt(st.nextToken());
                long result = getSum(1, N, 1, 1, v) + arr[v];   //변화량 + arr기존값
                sb.append(result).append('\n');
            }
        }

        System.out.println(sb.toString());
        br.close();
    }

    private static long getSum(int left, int right, int node, int u, int v) {
        if (v < left || right < u)
            return 0;
        else if (u <= left && right <= v)
            return sumtree[node];

        int mid = (left + right) / 2;
        return getSum(left, mid, node * 2, u, v) +
               getSum(mid + 1, right, node * 2 + 1, u, v);
    }

    private static long update(int left, int right, int node, int i, int k) {
        if (left <= i && i <= right) {
            if (left == right)
                return sumtree[node] += k;
            int mid = (left + right) / 2;
            sumtree[node] = update(left, mid, node * 2, i, k) +
                            update(mid + 1, right, node * 2 + 1, i, k);
        }
        return sumtree[node];
    }
}

/*
public class BOJ_16975 {

	static long[] tree;
	static int n;
	static void add(int pos, int val) {
		while(pos <= n) {
			tree[pos] += val;
			pos += (pos&-pos);
		}
	}
	
	static long sum(int pos) {
		long result = 0;
		while(pos > 0) {
			result += tree[pos];
			pos &= (pos-1);
		}
		return result;
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new long[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev = Integer.parseInt(st.nextToken());
		int now;
		add(1, prev);
		for(int i=2; i<=n; i++) {
			now = Integer.parseInt(st.nextToken());
			add(i, now - prev);
			prev = now;
		}
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			
			if(op == 1) {
				int b = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				
				add(a, k);
				add(b+1, -k);
			}else {
				sb.append(sum(a)+"\n");
			}
            
		}
		System.out.println(sb.toString());
		
	}
}
*/
