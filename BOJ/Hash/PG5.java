package BOJ.Hash;

// "����Ʈ�ٹ�"

import java.util.*;
import java.util.stream.Collectors;

public class PG5 {
    public static void main(String[] args) {solution();}

    static String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    static int[] plays = {500, 600, 150, 800, 2500};

    public static int[] solution() {
        Map<String, Integer> genreSum = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>(); // int[] = {index, playCount}
        StringTokenizer st;

        for (int i = 0; i < genres.length; i++) {
            genreSum.put(genres[i], genreSum.getOrDefault(genres[i], 0) + plays[i]);
            genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }

        // �帣�� �� ����� �������� �������� ����
        List<String> sortedGenres = genreSum.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            // �帣 ������ ��� �� ��������, ������ index ��������
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

            result.add(songs.get(0)[0]);

            if (songs.size() > 1) // �� �帣�� ���� 2�� �̻� �ִٸ�
                result.add(songs.get(1)[0]); // �� ��°�� ���� ����� ��(�ε���) �߰�
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
