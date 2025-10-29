package BOJ;

import BOJ.Collections.DataStructureAnswer;
import BOJ.Collections.DataStructureTest;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringTokenizer st;
    static StringBuilder sb;
    static List<Integer> list = new ArrayList<>();
    static int[] team;
    static boolean[] visit;
    static int[] arr, brr, dp, dp2;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n, m, e, v;
    static int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
//        Set<String> set = new HashSet<>();
//        Queue<String> q = new LinkedList<>();
//        HashSet<String> sets = new HashSet<>();
//        char[] result = new char[5];
//        result[0] = 'c';
//        result[1] = 'b';
//        String str = String.valueOf(result);
//        System.out.println(str);
        DataStructureTest.Test();
//        Map<Integer, int[]> map = new HashMap<>();
//        map.put(1, new int[]{0,0});
    }

    public String[] solution(int n1, int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder();
        String[] answer = {};
        n = n1;
        for(int i = 0; i < n; i++) {
        }
        return answer;
    }

    public String modulo(int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        while(n-->0) {
            int s1 = num1 % 2;
            int s2 = num2 % 2;
            if(s1 == 0 && s2 == 0) sb.append(" ");
            else sb.append("#");

            if(num1 != 0) num1 /= 2;
            if(num2 != 0) num2 /= 2;
        }
        return sb.toString();
    }
}










