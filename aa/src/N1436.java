/*
 * https://www.acmicpc.net/problem/1436
 * 영화감독 숌
 */

import java.util.Scanner;

public class N1436 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int target = in.nextInt();
		int num = 666;
		int count = 1;

		while (target != count) {
			num++;
			// "666" 이 포함된 숫자의 순번에 따라 영화제목에 들어간다
			if ((num + "").contains("666")) {
				count++;
			}
		}

		System.out.println(num);

		in.close();

		return;
	}
}