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
            //구간 벗어나는 최댓값 제거
            while (!deq.isEmpty() && deq.peekLast().idx + D < i) {
                deq.pollLast();
            }

            if (deq.isEmpty()) {
                deq.offer(node[i]);
                continue;
            }

            //node[i].data가 0이상이라면 최댓값 갱신
            if (deq.peekLast().data <= deq.peekLast().data + node[i].data) {
                deq.addLast(new Node(i, deq.peekLast().data + node[i].data));
            }
            //node[i].data가 음수라면 (현재 최댓값 + node[i].data)보다 작은 최댓값 제거 및 추가
            else {
                while (deq.size() > 1 &&
                       deq.peekFirst().data <= deq.peekLast().data + node[i].data) {
                    deq.pollFirst();
                }
                deq.addFirst(new Node(i, deq.peekLast().data + node[i].data));
            }

            //node[i].data가 최댓값인 경우 최댓값 갱신
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
deque를 이용해 배열을 한번 순회하면서, 작은 인덱스의 dp값들을 이용해 
현재 인덱스의 dp를 채우는 bottom-up 풀이이다.
dp[i]에 들어가는 것은 도착점이 i인 경우의 최대 점수이고, 
덱 안에 들어가는 것은 dp값들의 가장 긴 감소하는 부분수열이다.
dp[i]를 채울 때 고려해야 할 것은 dp[i - D]부터 dp[i - 1]까지이고, 
dp[i]에 들어갈 것은 그 중 최댓값 + a[i]일 것이다.
덱에는 상기했듯이 감소수열이 들어가고, 즉 덱의 맨 앞 값이 최댓값이므로 
그냥 덱의 맨 앞 값을 쓰면 된다.
 
1. 덱의 맨 앞 인덱스가 i - D 보다 작다면 어차피 갈 수 없으니까 뺀다. 
i는 계속 증가하므로 다시 볼 일 없는 친구들이다.
2. dp[i]에 덱의 맨 앞 값 + a[i]를 넣는다.
3. 덱의 뒤에서 dp[i]보다 작은 값을 모두 빼고, 
dp[i]를 넣는다. 원래 덱은 가장 긴 감소하는 부분수열이었으므로, 이렇게 해도 가장 긴 감소하는 부분수열이라는 점은 유지된다.
배열을 한 번 순회하므로 시간복잡도는 O(n)이다. 
이런 방식을 모노토닉 큐(monotonic queue)라고 한다고 한다.
*/
