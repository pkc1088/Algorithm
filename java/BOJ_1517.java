import java.io.*;
import java.util.*;
//https://loosie.tistory.com/328
//https://gre-eny.tistory.com/207  ÀÌ Ç®ÀÌ°¡ ÁÁÀ½
public class BOJ_1517 {

    static int n;
    static long[] elements, index, tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        elements = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }

        Map<Long, Integer> pos = new HashMap<>();
        for(int i=0; i<n; i++) {
            pos.put(elements[i], i);
        }
        index = elements.clone();
        Arrays.sort(index);

        tree = new long[getTreeSize()];

        long ans =0;
        for(int i=0; i<n; i++)	{
            int left = pos.get(index[i]);
            System.out.println("left : "+left);
            ans += sum(0, n-1, 1, left+1, n-1);

            update(0, n-1, 1, left, 1);
        }
        System.out.println(ans);
    }

    static int getTreeSize() {
        int h = (int)Math.ceil(Math.log(n)/Math.log(2))+1;
        return (int)Math.pow(2, h)-1;
    }

    static long sum(int start, int end, int node, int left, int right) {
        System.out.println("sum : "+start+", "+end+", "+node+", "+left+", "+right);
        if(end < left || right < start )
            return 0;
        if(left <= start && end <= right) {
            System.out.println("tree[node] : "+tree[node]);
            return tree[node];
        }

        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right) +
                sum(mid+1, end, node*2+1, left, right);
    }

    static void update(int start, int end, int node, int idx, int dif) {
        System.out.println("update : "+start+", "+end+", "+node+", "+idx+", "+dif);
        if (idx < start || idx > end) {
            return;
        }

        // 범위 안에 있으면 내려가며 다른 원소도 갱신
        tree[node] += dif;
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, dif);
        update(mid + 1, end, node * 2 + 1, idx, dif);
    }

}

/*
class Main {
    static int stoi(String s) { return Integer.parseInt(s);}

    static long swapCount = 0;
    static long[] sorted;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = stoi(br.readLine());
        sorted = new long[n];
        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = stoi(st.nextToken());

        mergeSort(arr, 0, n-1);

        System.out.println(swapCount);
    }

    static void mergeSort(long[] arr, int low, int high) {
        if(low < high) {
            int mid = (low+high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(long[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int index = low;

        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j])
                sorted[index++] = arr[i++];
            else {
                sorted[index++] = arr[j++];
                swapCount += (mid + 1 - i);
            }
        }

        while(i <= mid)
            sorted[index++] = arr[i++];

        while(j <= high)
            sorted[index++] = arr[j++];

        for(int k=low; k<=high; k++)
            arr[k] = sorted[k];
    }
}

 */
