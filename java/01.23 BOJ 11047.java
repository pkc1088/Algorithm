import java.io.*;
import java.util.*;

public class Main {
    public static int[] coin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int index = 0, bigCoin = 1, coinNum = 0;
        boolean passed = false;
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            if(coin[i] > k && !passed) {
                bigCoin = coin[i - 1];
                index = i - 1;
                passed = true;
            }
        }
        if(!passed) {
            bigCoin = coin[n - 1];
            index = n - 1;
        }


        while(bigCoin > 0) {
            coinNum += k / bigCoin;
            k %= bigCoin;
            if(k == 0) break;
            if(k == 1) {
                coinNum += 1;
                break;
            }
            bigCoin = coin[(--index)];
        }

        System.out.println(coinNum);
    }
}
