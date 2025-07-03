package BOJ.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2580 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] arr;
    static boolean[][] check, cbox;
    static int N = 9;
    public static void main(String[] args) throws IOException {
        arr = new int[9][9];
        check = new boolean[9][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        //bw.write(cnt);
        //bw.flush();
        //bw.close();
    }

    public static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }
        // 행과 열이 모두 채워졌을 경우 출력 후 종료
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            // 출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        if(arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                // i 값이 중복되지 않는지 검사
                if (possibility(row, col, i)) {
                    arr[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        dfs(row, col + 1);
    }
    public static boolean possibility(int row, int col, int value) {

        // 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }
        // 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) {
                return false;
            }
        }
        // 3*3 칸에 중복되는 원소가 있는지 검사
        int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
        int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치
        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }
        return true; // 중복되는 것이 없을 경우 true 반환
    }
}

/*
import java.util.Scanner;
import java.io.IOException;

public class Main {

	static boolean print = false;
	static int zeroCnt = 0;
	static int [][]map = new int[9][9];
	static int [][]zeroPos = new int[81][2];
	static boolean [][]row = new boolean[9][10];
	static boolean [][]col = new boolean[9][10];
	static boolean [][]square = new boolean[9][10];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        for(int r = 0; r < 9; r++) {
        	for(int c = 0; c< 9; c++) {
        		map[r][c] = sc.nextInt();
        		if(map[r][c] == 0) {
        			zeroPos[zeroCnt][0] = r;
        			zeroPos[zeroCnt][1] = c;
        			zeroCnt++;
        		}else {
        			row[r][map[r][c]] = true;
        			col[c][map[r][c]] = true;
        			square[(r/3)*3 + (c/3)][map[r][c]] = true;
        		}
        	}
        }
        back(0);
    	sc.close();
    }

    public static void back(int cnt) {
    	if(cnt >= zeroCnt) {
    		for(int r = 0; r < 9; r++) {
    			for(int c = 0; c < 9; c++) {
    				System.out.print(map[r][c] + " ");
    			}
    			System.out.println();
    		}
    		print = true;
    		return;
    	}
    	if(print) return;

    	int r = zeroPos[cnt][0];
    	int c = zeroPos[cnt][1];
    	for(int num = 1; num <= 9; num++) {
    		if(!row[r][num] && !col[c][num] && !square[(r/3)*3 + (c/3)][num]) {
    			map[r][c] = num;
    			row[r][num] = true;
    			col[c][num] = true;
    			square[(r/3)*3 + (c/3)][num] = true;
    			back(cnt+1);
    			if(print) return;
    			map[r][c] = 0;
    			row[r][num] = false;
    			col[c][num] = false;
    			square[(r/3)*3 + (c/3)][num] = false;
    		}
    	}
    }
}

 */