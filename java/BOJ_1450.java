import java.util.*;
import java.io.*;

public class BOJ_1450 {
    static int n, c, cnt = 0, idx = 0;
    static int[] bags;
    static ArrayList<Integer> listA = new ArrayList<>();
    static ArrayList<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        find();
    }

    static void find() {
        findA(0, 0);
        findB(n / 2, 0);

        listB.sort((i, j) -> (i - j));
        for (int i = 0; i < listA.size(); i++) {
            idx = -1;
            binarySearch(0, listB.size() - 1, listA.get(i));
            cnt += idx + 1; // 안넣는경우 +1인듯?
        }

        System.out.println(cnt);
    }

    static void binarySearch(int start, int end, int value) {
        if(start > end)
            return;
        int mid = (start + end) / 2;

        if (listB.get(mid) + value <= c) {
            idx = mid;
            binarySearch(mid+1, end, value);
        } else {
            binarySearch(start, mid - 1, value);
        }
    }
        /*
        while (start <= end) {
            int mid = (start + end) / 2;
            if (listB.get(mid) + value <= c) {
                idx = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        */


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        bags = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bags[i] = Integer.parseInt(st.nextToken());
        }

    }

    static void findA(int k, int sum) {
        if (sum > c)
            return;

        if (k == n / 2) {
            listA.add(sum);
            return;
        }

        findA(k + 1, sum);
        findA(k + 1, sum + bags[k]);
    }

    static void findB(int k, int sum) {
        if (sum > c)
            return;
        if (k == n) {
            listB.add(sum);
            return;
        }
        findB(k + 1, sum);
        findB(k + 1, sum + bags[k]);
    }

}
