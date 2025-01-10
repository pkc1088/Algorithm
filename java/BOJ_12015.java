import java.io.*;
import java.util.*;

public class BOJ_12015 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < n; i++) {
            int value = arr[i] = Integer.parseInt(st.nextToken());

            if(value > list.get(list.size() - 1))	
                list.add(value);

            else{
                int left = 0;
                int right = list.size() - 1;	//그냥 순서상 제일 오른쪽끝을말함

                while(left < right) {
                    int mid = (left + right) >> 1;  // (left + right) / 2 랑 같은 의미
                    if(list.get(mid) >= value){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                list.set(right, value);
            }
        }
        System.out.println(list.size() - 1);
    }

}
