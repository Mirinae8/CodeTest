/*
 * https://www.acmicpc.net/problem/2563
 * 색종이
 */

import java.util.Scanner;

public class N2563 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean[][] dimension = new boolean[100][100];
		int result = 0;

		int count = in.nextInt();

		while (count > 0) {
			count--;

			int x = in.nextInt();
			int y = in.nextInt();

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					dimension[i][j] = true;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (dimension[i][j] == true) {
					result++;
				}
			}
		}

		System.out.println(result);

		in.close();

		return;
	}
}
