/*
 * https://www.acmicpc.net/problem/24313
 * 알고리즘 수업 - 점근적 표기 1
 */

import java.util.Scanner;

public class N24313 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a1 = in.nextInt();
		int a0 = in.nextInt();
		int c = in.nextInt();
		int n0 = in.nextInt();
		boolean result = true;

		for (int n = n0; n <= 100; n++) {
			// n0부터 100까지의 n에 대해서
			// f(n) <= c * g(n) 을 만족해야 한다
			// g(n) 을 값이 n이랑 같다고 예제에 나와있으나 문제 설명만으로는 g(n) = n 을 이해하지 못했다
			if (a1 * n + a0 > c * n) {
				result = false;
				break;
			}
		}

		System.out.println(result == true ? "1" : "0");

		in.close();

		return;
	}
}
