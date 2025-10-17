package BOJ.Collections;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class DataStructure {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
//    // static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
//    // static PriorityQueue<Integer> pq = new PriorityQueue<>();
//    static Map<Integer, Integer> map = new HashMap<>();
//    static StringBuilder sb = new StringBuilder();
//    static List<int[]> list = new ArrayList<>();
//    static Queue<int[]> q = new LinkedList<>();
//    static int max = Integer.MIN_VALUE;
//    static int min = Integer.MAX_VALUE;
//    static int n, m, h, r, v, e, t, k, l, s, cnt, ans;
//    static int[] dr = {-1, 0, 1, 0};
//    static int[] dc = {0, 1, 0, -1};
//    static StringTokenizer st;
//    static boolean[] visit;
//    static int[] arr, brr;
//    static int[][] crr;

    public static void main(String[] args) throws IOException {
        int[] visit = new int[5];
        int depth = 1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        ArrayList<Integer> list = graph.get(0);
        for(Integer i : list) {
            visit[i] = depth;
        }

    }

    public static void binarySearch() {
        int number = 10;
        int number2 = 20;
        String binaryString = Integer.toBinaryString(number); // num1 | num2
        System.out.println(binaryString); // "1010"

        // 반드시 오름차순으로 정렬되어 있어야 함
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        // 찾는 값이 있는 경우
        System.out.println(Collections.binarySearch(list, 30));
        // 결과: 2 (30은 index 2에 있음)
        // 찾는 값이 없는 경우
        System.out.println(Collections.binarySearch(list, 25));
        // 결과: -3
        // 25를 넣으려면 인덱스 2에 들어가야 한다 (10, 20, 25, 30, 40, 50)
        // 삽입 위치 2
        // 반환값 공식 -(2) - 1 = -3
        int idx = Collections.binarySearch(list, 25);
        if (idx < 0) idx = -(idx + 1);  // idx = 2

        List<String> list1 = Arrays.asList("apple", "banana", "cherry");
        int idx1 = Collections.binarySearch(list1, "banana", Comparator.naturalOrder());
        System.out.println(idx1); // 1
    }

    public static void boxed() {
        int[] arr = {1, 2, 3, 5};
        Integer[] wrapperCts = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(wrapperCts, Comparator.reverseOrder());

        int[] temp = Arrays.copyOfRange(arr, 0, 1);
        Arrays.sort(temp);
        System.out.println(Arrays.stream(temp).boxed().collect(Collectors.toList()));

    }

    public static void StringRegrex() {
        String text = "apple, banana. cherry";
        String text2 = "[apple].ban ana,[cherry,date]";
        String[] parts1 = text.split("[.,\\[\\]] | \\s+");
        String[] parts2 = text.split("[.,\\[\\]]");

        for (String part : parts1) System.out.println(part);

    }

    public static void Collections() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        System.out.println(q.size());
        System.out.println(q.poll());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(1);
        pq.add(2);
        System.out.println(pq.poll());
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(4);
        System.out.println(st.pop());
        Map<String, Integer> map = new HashMap<>();
        map.put("banana", 1);
        map.put("apple", 2);
        for(String s : map.keySet()) {
            System.out.println(s + ": " + map.get(s));
        }
    }
    public static void collectionsSort() {
        String str1 = "a1b2c3";
        String[] p = str1.split("");
        List<String> list1 = new ArrayList<>(Arrays.asList(p));
        Collections.reverse(list1);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);
        list1.sort(Comparator.reverseOrder());
        System.out.println(list1);

        int[][] brr = {{2,7}, {3,5}, {1, 9}};
        Arrays.sort(brr, (a,b)->a[1]-b[1]);
        for (int i = 0; i < brr.length; i++) {
            System.out.print(Arrays.toString(brr[i]));
        } System.out.println();
    }
    public static void stringList() {
        String str1 = "a1b2c3";
        String str2 = "1234";
        String str3 = "abcd";
        String substr = str1.substring(0,3);
        String[] p = str3.split("");

        int k = Integer.parseInt(str2);
        int m = 100;
        String z = String.valueOf(m);
        int[] arr = {1, 3, 2, 4};
        List<String> list1 = new ArrayList<>(Arrays.asList(p));
        List<String> list = new ArrayList<>();
        String[] newArr = list.toArray(new String[0]);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println(list1);
        System.out.println(k);
        System.out.println(z + ": " + z.getClass());
        System.out.println(substr);
        System.out.println(Arrays.toString(p));
    }
    public static void twoDimensionArray() {
        int[] arr = {1, 3, 2, 4};
        int[][] brr = new int[3][4];
        for(int i = 0; i < brr.length; i++) {
            for(int j = 0; j < brr[0].length; j++) {
                brr[i][j] = arr[0];
            }
        }
        int[] crr = new int[5];
        Arrays.fill(crr, -1);

        int[][] drr = new int[3][4];
        for(int i = 0; i < drr.length; i++) {
            drr[i] = arr.clone();
        }
        System.out.println(Arrays.toString(crr));
        System.out.println(Arrays.toString(brr[0]));
        System.out.println(Arrays.toString(drr[2]));
    }
    public static void arrayToList() {
        int[] brr = {1, 3, 2, 4};
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < brr.length; i++) {
            list1.add(brr[i]);
        }
        List<Integer> list2 = Arrays.stream(brr).boxed().toList();
        int[] crr = list2.stream().mapToInt(i->i).toArray();

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(Arrays.toString(crr));
    }
    public static void arraySort() {
        int[] brr = {1, 3, 2, 4};
        int[] arr = brr.clone();
        arr[0] = -1;
        Integer[] crr = {4, 2, 1, 5};
        Arrays.sort(brr);
        Arrays.sort(crr, Comparator.reverseOrder());
        int[] drr = new int[brr.length];
        for(int i = 0; i < brr.length; i++) {
            drr[i] = brr[brr.length - i - 1];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(brr));
        System.out.println(Arrays.toString(crr));
        System.out.println(Arrays.toString(drr));
    }

/*
    public static void temp() {
        String str = "abcdefghi";
        arr = new int[10]; arr[0] = -1;
        brr = arr.clone(); brr[0] = -2;
        int[][] board = new int[3][4];
        int[][] cloned = new int[board.length][];

        for (int i = 0; i < board.length; i++) cloned[i] = board[i].clone();

        int[] sub = Arrays.copyOfRange(arr, 0, 1);

        String[] words = {"a","b","c"};
        List<String> list = new ArrayList<>(Arrays.asList(words)); // 가변 크기 리스트가 됨.
        List<String> list2 = Arrays.asList(words); // 고정 크기 리스트라 add, remove 불가능.
        list.add("d"); // list2.add("d"); 불가

        String[] newArr = list.toArray(new String[0]);
        String str2 = "a1b2c3";
        String str3 = "b_a_c";
        StringTokenizer st = new StringTokenizer(str3, "_");

        int z = 42;
        String parseZ = String.valueOf(z);
        parseZ += 1; z += 1;

        int[][] arr2d = {{1,9},{2,5},{3,7}};
        Integer[] arr1d = {2, 5, 3, 7};
        Arrays.sort(arr2d, (a,b) -> a[1] - b[1]); // 두 번째 원소 기준 오름차순
        Arrays.sort(arr1d, Comparator.reverseOrder()); // 래퍼 타입 배열에서만
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 작은 값 우선
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder()); // 큰 값 우선

        List<Integer> list3 = new ArrayList<>(List.of(1, 2, 5, 3));

        int[] nums = {1,2,3};
        List<Integer> numList = Arrays.stream(nums).boxed().toList();// int 배열 → 리스트
        int[] back = numList.stream().mapToInt(i -> i).toArray();// 리스트 → int 배열

        int[][] grid = new int[3][4];
        for (int[] row : grid) {
            Arrays.fill(row, -1);
        }

        int pk = Integer.parseInt("123"); // 문자열 -> 숫자
        String fk = String.valueOf(123); // 숫자 -> 문자열
        char c = '7'; int num = c - '0'; // 숫자 문자 → 숫자

        String[] participants = {"leo", "kiki", "eden", "leo"};
        Map<String, Integer> map = new HashMap<>();
        for (String p : participants) {
            map.put(p, map.getOrDefault(p, 0) + 1); // 결과: {eden=1, kiki=1, leo=2}
        }
        map.put("apple", 3);
        for (String key : map.keySet()) {
            System.out.print(key + " -> " + map.get(key) + ", ");
        }


        System.out.println(st.nextToken());
        System.out.println(list3);
        System.out.println(Arrays.toString(arr2d[0]));
        System.out.println(list.get(0) + ", " + list.get(1));
        System.out.println(parseZ + ", " + z);
        System.out.println(str2.charAt(0));
        System.out.println(newArr[0]);
        System.out.println(list2.get(0));
        System.out.println(board.length + ", " + board[0].length);
        System.out.println(str.substring(1, 4));
        System.out.println(Arrays.toString(sub));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(brr));
    }
*/
}











