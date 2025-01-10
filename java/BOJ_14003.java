import java.io.*;
import java.util.*;
public class BOJ_14003 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 이분탐색을 통해 증가하는 수열을 저장할 객체
        List<Integer> list = new ArrayList<>();
        // 입력된 수열을 저장
        int arr[] = new int[n + 1];
        // 입력된 각 수열의 위치를 저장
        int indexArr[] = new int[n + 1];

        // 수열을 입력받아 저장한다.
        for(int i = 1 ; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        list.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= n; i++){
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;

            // 확인하는 숫자가 수열의 마지막 수보다 큰 경우
            // 수열에 추가해준다.
            if(num > list.get(list.size() - 1)) {
                list.add(num);
                indexArr[i] = list.size() - 1;
            }
            // 확인하는 숫자가 수열의 마지막 수보다 작은 경우
            else{
                while(left < right){
                    int mid = (left + right) /2;

                    if(list.get(mid) >= num)
                        right = mid;
                    else
                        left = mid + 1;
                }
                list.set(right, num);
                indexArr[i] = right;
            }
        }
       
        sb.append(list.size() - 1 + "\n");
        Stack<Integer> stack = new Stack();

        int index = list.size() - 1;

        for(int i = n; i > 0; i--){
            if(indexArr[i] == index){
                index--;
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

