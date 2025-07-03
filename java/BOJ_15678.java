import java.util.*;
import java.io.*;


public class BOJ_15678 {
	static int N, M;
	static long[] arr, DP;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src\\P_12_1\\B_15678_D.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		DP = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> deque = new LinkedList<Integer>();
		long result = -1000000001;
		for (int i = 0; i < N; i++) {
			while (!deque.isEmpty() && deque.peekFirst() < i - D) {
				deque.removeFirst();
			}

			DP[i] = deque.isEmpty() ? arr[i] : Math.max(DP[deque.peekFirst()] + arr[i], arr[i]);
			result = Math.max(result, DP[i]);

			while (!deque.isEmpty() && DP[deque.peekLast()] < DP[i]) {
				deque.removeLast();
			}

			deque.offerLast(i);

		}

		System.out.println(result);

	}

}










/*
public class BOJ_15678 {

    static class Node {
        int idx;
        long data;

        public Node (int idx, long data) {
            this.idx = idx;
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Node[] node = new Node[N];
        for (int i = 0; i < N; ++i) {
            long data = Long.parseLong(st.nextToken());
            node[i] = new Node(i, data);
        }

        Deque<Node> deq = new ArrayDeque<>();
        long ans = -(long)1e12;

        for (int i = 0; i < N; i++) {
            //���� ����� �ִ� ����
            while (!deq.isEmpty() && deq.peekLast().idx + D < i) {
                deq.pollLast();
            }

            if (deq.isEmpty()) {
                deq.offer(node[i]);
                continue;
            }

            //node[i].data�� 0�̻��̶�� �ִ� ����
            if (deq.peekLast().data <= deq.peekLast().data + node[i].data) {
                deq.addLast(new Node(i, deq.peekLast().data + node[i].data));
            }
            //node[i].data�� ������� (���� �ִ� + node[i].data)���� ���� �ִ� ���� �� �߰�
            else {
                while (deq.size() > 1 &&
                       deq.peekFirst().data <= deq.peekLast().data + node[i].data) {
                    deq.pollFirst();
                }
                deq.addFirst(new Node(i, deq.peekLast().data + node[i].data));
            }

            //node[i].data�� �ִ��� ��� �ִ� ����
            if (deq.peekLast().data <= node[i].data) {
                deq.addLast(new Node(i, node[i].data));
            }
            ans = Math.max(ans, deq.peekLast().data);
        }

        System.out.println(ans);
    }
}



#include <bits/stdc++.h>
 
using namespace std;
 
int N, D;
long long a[100000], dp[100000];
deque<pair<long long, long long>> q;
 
int main()
{
    cin >> N >> D;
    for (int i = 0; i < N; i++)
        cin >> a[i];
    for (int i = 0; i < N; i++)
    {
        dp[i] = a[i];
        while (!q.empty() && q.front().first < i - D)
            q.pop_front();
        if (!q.empty())
            dp[i] = max(dp[i], q.front().second + a[i]);
        while (!q.empty() && q.back().second < dp[i])
            q.pop_back();
        q.push_back(make_pair(i, dp[i]));
    }
    cout << *max_element(dp, dp + N);
}

/*
deque�� �̿��� �迭�� �ѹ� ��ȸ�ϸ鼭, ���� �ε����� dp������ �̿��� 
���� �ε����� dp�� ä��� bottom-up Ǯ���̴�.
dp[i]�� ���� ���� �������� i�� ����� �ִ� �����̰�, 
�� �ȿ� ���� ���� dp������ ���� �� �����ϴ� �κм����̴�.
dp[i]�� ä�� �� ����ؾ� �� ���� dp[i - D]���� dp[i - 1]�����̰�, 
dp[i]�� �� ���� �� �� �ִ� + a[i]�� ���̴�.
������ ����ߵ��� ���Ҽ����� ����, �� ���� �� �� ���� �ִ��̹Ƿ� 
�׳� ���� �� �� ���� ���� �ȴ�.
 
1. ���� �� �� �ε����� i - D ���� �۴ٸ� ������ �� �� �����ϱ� ����. 
i�� ��� �����ϹǷ� �ٽ� �� �� ���� ģ�����̴�.
2. dp[i]�� ���� �� �� �� + a[i]�� �ִ´�.
3. ���� �ڿ��� dp[i]���� ���� ���� ��� ����, 
dp[i]�� �ִ´�. ���� ���� ���� �� �����ϴ� �κм����̾����Ƿ�, �̷��� �ص� ���� �� �����ϴ� �κм����̶�� ���� �����ȴ�.
�迭�� �� �� ��ȸ�ϹǷ� �ð����⵵�� O(n)�̴�. 
�̷� ����� ������ ť(monotonic queue)��� �Ѵٰ� �Ѵ�.
*/
