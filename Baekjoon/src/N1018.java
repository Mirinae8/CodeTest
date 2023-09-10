/*
 * https://www.acmicpc.net/problem/1018
 * 체스판 다시 칠하기
 */

import java.util.Scanner;

public class N1018 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		boolean[][] board = new boolean[x][y];
		int result = 32; // 최소값을 저장하는 변수 초기값은 최대인 32

		for (int i = 0; i < x; i++) {
			String str = in.next();
			for (int j = 0; j < y; j++) {
				board[i][j] = str.charAt(j) == 'W' ? true : false;
			}
		}

		// 8x8 칸으로 떼어내야 한다
		for (int i = 0; i <= x - 8; i++) {
			for (int j = 0; j <= y - 8; j++) {
				boolean[][] pick = new boolean[8][8];
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						pick[k][l] = board[i + k][j + l];
					}
				}
				
				int num = getNum(pick);

				result = result > num ? num : result;
			}
		}
		
		System.out.println(result);
		
		in.close();
		
		return;
	}

	public static int getNum(boolean[][] ary) {
		int even = 0;  // 맨 왼쪽 위 칸이 흰색(true)
		int odd = 0;  // 맨 왼쪽 위 칸이 검은색(false)
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) { // 2차원 배열의 위치 합이 짝수인 경우
					if (ary[i][j] == true) { // 흰색
						odd++; // 검은색으로 칠해야 하므로
					} else { // 검은색
						even++; // 흰색으로 칠해야 하므로
					}
				} else { // 2차원 배열의 위치 합이 홀수인 경우
					if (ary[i][j] == true) { // 흰색
						even++; // 검은색으로 칠해야 하므로
					} else { // 검은색
						odd++;  // 흰색으로 칠해야 하므로
					}
				}
			}
		}

		return even < odd ? even : odd;
	}
}
