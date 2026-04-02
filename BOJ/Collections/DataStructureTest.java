package BOJ.Collections;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class DataStructureTest {

    public static void main(String[] args) throws IOException {
        Test();
    }

    public static void Test() throws IOException {
        // 1차원 배열 선언(arr)
        int[] arr = new int[10];
        // -1로 arr 채우기
        Arrays.fill(arr, -1);
        // 2차원 배열 선언(arr2)
        int[][] arr2 = new int[10][10];
        // arr2에 arr로 복사하기
        for(int i = 0; i < arr.length; i++) {
            arr2[i] = arr.clone();
        }
        // 0 <= arr 인덱스 < 1 만큼 brr 로 복사
        int[] brr = Arrays.copyOfRange(arr, 0, 1);
        // 정수 리스트 선언(list)
        ArrayList<Integer> list = new ArrayList<>();
        // 정수 그래프 선언
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // 그래프 10만큼 초기화
        for(int i = 0; i < 10; i++) {
            graph.add(new ArrayList<>());
        }
        int ss = graph.size();
        int ss2 = "qwe".length();
        int ss3 = arr.length;

        // 큐
        Queue<Integer> q = new LinkedList<>();
        // 비었는지 확인 후 추가 및 제거
        if(q.isEmpty()) q.add(10); q.offer(10); q.poll();
        // 힙 초기화 + 역정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // 스택
        Stack<Integer> stk = new Stack<>();
        // 추가 및 제거
        stk.push(10); stk.pop();
        // 셋
        Set<Integer> set = new HashSet<>();
        // 4 포함하는지 체크 후 4 추가
        if(!set.contains(4)) set.add(4);

        // 맵 <String, Integer>
        Map<String, Integer> map = new HashMap<>();
        // 추가 2가지 버전
        map.put("apple", 99);
        System.out.println("apple: " + map.get("apple"));
        map.put("apple", map.getOrDefault("apple", 0) + 1);
        System.out.println("apple: " + map.get("apple"));
        // 키가 존재하지 않을 때만 새로운 값을 계산하여 Map 에 추가하고 그 값을 반환
        map.computeIfAbsent("banana", k -> 200);
        System.out.println("banana: " + map.get("banana"));
        // 맵에서 특정 키 확인하고 변경 하거나 제거
        if(map.containsKey("banana")) {
            map.replace("banana", 201);
            System.out.println("banana: " + map.get("banana"));
        }
        map.remove("banana");
        System.out.println("removed: " + map.get("banana"));
        // 맵 <String, List<String>>
        Map<String, List<String>> groups = new HashMap<>();
        // Alice 키 없으면 새로운 리스트 생성 후 값으로 문자열 넣기, 키 이미 존재하면 기존 list 반환
        String student = "Alice";
        groups.computeIfAbsent(student, k -> new ArrayList<>()).add("java");
        groups.computeIfAbsent(student, k -> new ArrayList<>()).add("C++");
        System.out.println(groups.get(student));
        // 맵에서 키와 값 추출
        for (String keys : map.keySet()) {
            System.out.println("keys: " + keys + ", values: " + map.get(keys));
        }
        System.out.println(map);
        System.out.println(groups);
        // 디큐
        Deque<String> dq = new ArrayDeque<>();
        // 앞쪽 추가/제거, 뒤쪽 추가/제거
        dq.addFirst("a"); dq.removeFirst(); dq.pollFirst();
        dq.addLast("b"); dq.removeLast(); dq.pollLast();

        // int[] -> Integer[]
        Integer[] newArr1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        // List<Integer> -> Integer[]
        Integer[] newArr2 = list.toArray(Integer[]::new);
        // Integer[] -> int[]
        int[] newArr3 = Arrays.stream(newArr1).mapToInt(i -> i).toArray();
        // List<Integer> -> int[]
        int[] newArr4 = list.stream().mapToInt(i->i).toArray();
        // int[] -> List<Integer>
        List<Integer> newList = Arrays.stream(newArr4).boxed().toList();
        // Integer[] -> List<Integer>
        List<Integer> newList2 = Arrays.stream(newArr2).toList();


        // Integer[] 역정렬
        Arrays.sort(newArr2, Comparator.reverseOrder());
        // int[] arr 정렬
        Arrays.sort(arr);
        // int[] arr 역정렬
            // 수기로
        // List 뒤집기
        List<Integer> listt = new ArrayList<>();
        Collections.reverse(listt);
        // List 역정렬 세 가지
        listt.sort(Comparator.reverseOrder());
        Collections.sort(listt, Comparator.reverseOrder());
        Collections.sort(listt, Collections.reverseOrder());
        // 2차원 두 번째 요소로 오름차순 정렬
        Arrays.sort(arr2, (a,b) -> a[1] - b[1]);
        // 2차원 첫 요소로 내림차순, 두번째 요소로 오름차순 정렬
        Arrays.sort(arr2, (a,b) -> a[0] == b[0]
                ? a[1] - b[1]
                : b[0] - a[0]);
        // 1차원 순서 배열을 double 배열의 크기 순으로 정렬
        Integer[] stagesIdx = new Integer[10];
        double[] fail = new double[10 + 1];
        for (int i = 0; i < 10; i++) stagesIdx[i] = i + 1;

        Arrays.sort(stagesIdx, (a,b) -> {
            if (fail[a] == fail[b]) return Integer.compare(a, b); // 실패율 같으면 작은 번호 우선
            return Double.compare(fail[b], fail[a]); // 실패율 큰 순
        });

        // 문자열 str 선언과 substr 0~3
        String str = "asdf zxcv";
        String substr = str.substring(0, 3);
        // 문자열 배열 나누기
        String[] p = str.split("");
        System.out.println(Arrays.toString(p));
        // String[] -> List<String>
        System.out.println(Arrays.stream(p).toList());
        // 문자열 배열 나누기 정규식
        String text = "apple, banana. cherry";
        String text2 = "[apple].ban ana,[cherry,date]";
        // 파싱 int 와 str
        int a = Integer.parseInt("1");
        String b = String.valueOf(a);
        // String[] -> List<String>
        List<String> newlist = new ArrayList<>(Arrays.asList(p));
        System.out.println(newlist.get(2));
        // List<String> -> String[]
        String[] array = newlist.toArray(String[]::new);
        System.out.println(Arrays.toString(array));
        // BR, BW
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer, 토큰 존재 여부 및 다음 토큰
        StringTokenizer st = new StringTokenizer(str, "");
        if(st.hasMoreTokens()) System.out.print(st.nextToken() + " ");
    }
}
