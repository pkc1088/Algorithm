package BOJ;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {solution();}

    static String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    static int[] plays = {500, 600, 150, 800, 2500};

    public static int[] solution() {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(2);
        pq.offer(3);
        System.out.println(pq);

//        list.stream().mapToInt(i->i).toArray();
        return null;
    }
}











