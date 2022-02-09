import java.util.*;
/*
public class Main {
 
	public static int MAX = Integer.MIN_VALUE;	// �ִ� 
	public static int MIN = Integer.MAX_VALUE;	// �ּڰ� 
	public static int[] operator = new int[4];	// ������ ���� 
	public static int[] number;					// ���� 
	public static int N;						// ���� ���� 
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
		number = new int[N];
 
		// ���� �Է� 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
 
		// ������ �Է� 
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
 
		dfs(number[0], 1);
 
		System.out.println(MAX);
		System.out.println(MIN);
 
	}
 
	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			// ������ ������ 1�� �̻��� ���
			if (operator[i] > 0) {
 
				// �ش� �����ڸ� 1 ���ҽ�Ų��.
				operator[i]--;
 
				switch (i) {
 
				case 0:	dfs(num + number[idx], idx + 1);	break;
				case 1:	dfs(num - number[idx], idx + 1);	break;
				case 2:	dfs(num * number[idx], idx + 1);	break;
				case 3:	dfs(num / number[idx], idx + 1);	break;
 
				}
				// ���ȣ���� ����Ǹ� �ٽ� �ش� ������ ������ �����Ѵ�.
				operator[i]++;
			}
		}
	}
 
}
*/
public class Main {

    public static int n;
    // ������ �����ϰ��� �ϴ� �� ����Ʈ
    public static ArrayList<Integer> arr = new ArrayList<>();
    // ���ϱ�, ����, ���ϱ�, ������ ������ ����
    public static int add, sub, mul, divi;
    
    // �ּڰ��� �ִ� �ʱ�ȭ
    public static int minValue = (int) 1e9;
    public static int maxValue = (int) -1e9;

    // ���� �켱 Ž�� (DFS) �޼���
    public static void dfs(int i, int now) {
        // ��� �����ڸ� �� ����� ���, �ּڰ��� �ִ� ������Ʈ
        if (i == n) {
            minValue = Math.min(minValue, now);
            maxValue = Math.max(maxValue, now);
        }
        else {
            // �� �����ڿ� ���Ͽ� ��������� ����
            if (add > 0) {
                add -= 1;
                dfs(i + 1, now + arr.get(i));
                add += 1;
            }
            if (sub > 0) {
                sub -= 1;
                dfs(i + 1, now - arr.get(i));
                sub += 1;
            }
            if (mul > 0) {
                mul -= 1;
                dfs(i + 1, now * arr.get(i));
                mul += 1;
            }
            if (divi > 0) {
                divi -= 1;
                dfs(i + 1, now / arr.get(i));
                divi += 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr.add(x);
        }

        add = sc.nextInt();
        sub = sc.nextInt();
        mul = sc.nextInt();
        divi = sc.nextInt();

        // DFS �޼��� ȣ��
        dfs(1, arr.get(0));

        // �ִ񰪰� �ּڰ� ���ʴ�� ���
        System.out.println(maxValue);
        System.out.println(minValue);
    }
}
