import java.io.*;
import java.util.*;
public class BOJ_10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());

            // upperBound�� lowerBound�� ���� ���� ���Ѵ�.
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // lo�� hi�� ������ �� ���� �ݺ�
        while (lo < hi) {

            int mid = (lo + hi) / 2; // �߰���ġ�� ���Ѵ�.

            /*
             *  key ���� �߰� ��ġ�� ������ �۰ų� ���� ���
             *
             *  (�ߺ� ���ҿ� ���� �������� Ž���ϵ��� ��踦 ������.)
             */
            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

        }

        return lo;
    }

    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        // lo�� hi�� ������ �� ���� �ݺ�
        while (lo < hi) {

            int mid = (lo + hi) / 2; // �߰���ġ�� ���Ѵ�.

            // key���� �߰� ��ġ�� ������ ���� ���
            if (key < arr[mid]) {
                hi = mid;
            }
            // �ߺ������� ��� else���� ó���ȴ�.
            else {
                lo = mid + 1;
            }

        }

        return lo;
    }

}

/* hash  ��� 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
import java.util.StringTokenizer;
import java.util.HashMap;
 
 
public class BOJ_10816 {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		*  HashMap<Key, Value>
		*  Key = �ԷµǴ� ����
		*  Value = ������ ����(=�ߺ� �Է� �� ������ ��) 
		 
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			 * getOrDefault(key, defaultValue)
			 * key�� ���� map�� ���� �� value�� ��ȯ�Ѵ�.
			 * ���� value�� ���� ��� defaultValue���� ��ȯ�Ѵ�.
			 
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(map.getOrDefault(key, 0)).append(' ');
		}
		
		System.out.println(sb);
	}
}
*/

/* counting ��� 
public class BOJ_10816 {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int[] counting = new int[20000001]; // �Է¹޴� ���� ���� : -10,000,000 ~ 10,000,000
		
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0 ; i < N; i++) {
			counting[Integer.parseInt(st.nextToken()) + 10000000]++;	// �ش� �ε����� �� ����
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			sb.append(counting[Integer.parseInt(st.nextToken()) + 10000000]).append(' ');
		}
		System.out.println(sb);
	}
}
*/
