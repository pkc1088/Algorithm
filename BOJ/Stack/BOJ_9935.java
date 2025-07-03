package BOJ.Stack;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_9935 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st, tk;
    static ArrayList<Integer> list, list1, list2;
    static PriorityQueue<Long> pq;
    static String str, str1, str2;
    static boolean[][] visit2;
    static boolean[] visit;
    static int[][] dp2, brr2, arr2, board, result;
    static int[] dp, brr, arr, crr;
    static int n, m, k, a, b, c, ans = 0, cnt = 0, sum = 0, C = 0, real_idx = 0;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        str = br.readLine(); // 1,000,000
        String bombstr = br.readLine(); // 36
        char c;
        Stack<Character> stack = new Stack<>(), recover = new Stack<>(),
                bombstack = new Stack<>(), origin = new Stack<>();
        for (int i = 1; i < bombstr.length() + 1; i++) {
            bombstack.push(bombstr.charAt(i - 1));
        }

        boolean found = false;
        origin.addAll(bombstack);

        for (int i = 1; i < str.length() + 1; i++) {
            c = str.charAt(i - 1);
            stack.push(c);
            if (c == bombstack.peek()){

                while (!stack.isEmpty() && !bombstack.isEmpty() && stack.peek() == bombstack.peek()) { // bomstack이 비워질때까지 stack에서 제거
                    recover.push(stack.pop());
                    bombstack.pop();
                    if(bombstack.isEmpty()) {
                        found = true;
                        break;
                    }
                }
                while (!recover.isEmpty()) {
                    if(found) {
                        recover = new Stack<>();
                        found = false;
                        break;
                    }
                    stack.push(recover.pop());
                }
                bombstack.clear();
                bombstack.addAll(origin);
            }
        }

        if(stack.isEmpty()) System.out.println("FRULA");
        else {
            for (char ch : stack) sb.append(ch);
            System.out.println(sb.toString());
        }
    }

    public static void print(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

/*
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		String bomb = br.readLine();
		int str_len = str.length();
		int bomb_len = bomb.length();

		Stack<Character> stack = new Stack<>();

		for(int i=0; i<str_len; i++) {
			int count = 0;
			stack.push(str.charAt(i));

			// 스택의 크기가 폭탄 문자열의 길이와 같아지면 탐색 시작
			if(stack.size() >= bomb_len) {

				for(int j=0; j<bomb_len; j++) {

					if(stack.get(stack.size() - bomb_len + j) == bomb.charAt(j)) {
						count++;
					}

					if(count == bomb_len) {
						for(int k=0; k<bomb_len; k++) {
							stack.pop();
						}
					}

				}
			}
		}

		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			for(char ch : stack) {
				sb.append(ch);
			}
		}

		System.out.println(sb);

	}
}
 */