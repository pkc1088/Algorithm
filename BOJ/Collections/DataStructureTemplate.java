package BOJ.Collections;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DataStructureTemplate {
    public static void main(String[] args) throws IOException {
        Test();
    }

    public static void Test() throws IOException {
        // 1���� �迭 ����(arr)
        // -1�� arr ä���
        // 2���� �迭 ����(arr2)
        // arr2�� arr�� �����ϱ�
        // 0 <= arr �ε��� < 1 ��ŭ brr �� ����
        // ���� ����Ʈ ����(list)
        // ���� �׷��� ����
        // �׷��� 10��ŭ �ʱ�ȭ


        // ť
        // ������� Ȯ�� �� �߰� �� ����
        // �� �ʱ�ȭ + ������
        // ����
        // �߰� �� ����
        // ��
        // 4 �����ϴ��� üũ �� 4 �߰�
        // �� <String, Integer>
        // �߰� 2���� ����
        // �ʿ��� Ű�� �� ����
        // Ű�� �������� ���� ���� ���ο� ���� ����Ͽ� Map �� �߰��ϰ� �� ���� ��ȯ
        // �ʿ��� Ư�� Ű Ȯ���ϰ� ���� �ϰų� ����
        // �� <String, List<String>>
        // Alice Ű ������ ���ο� ����Ʈ ���� �� ������ ���ڿ� �ֱ�, Ű �̹� �����ϸ� ���� list ��ȯ
        // ��ť
        // ���� �߰�/����, ���� �߰�/����


        // arr -> Integer[]
        // Integer[] -> arr
        // arr -> list
        // list -> arr
        // Integer[] -> list
        // list -> Integer[]


        // Integer[] ������
        // int[] arr ����
        // int[] arr ������
        // List ������ �� ����
        // 2���� �� ��° ��ҷ� �������� ����
        // 2���� ù ��ҷ� ��������, �ι�° ��ҷ� �������� ����


        // ���ڿ� str ����� substr 0~3
        // ���ڿ� �迭 ������
        // ���ڿ� �迭 ������ ���Խ�
        String text = "apple, banana. cherry";
        String text2 = "[apple].ban ana,[cherry,date]";
        // �Ľ� int �� str
        // String[] -> List<String>
        // List<String> -> String[]
        // BR, BW
        // StringTokenizer, ��ū ���� ���� �� ���� ��ū
    }
}
