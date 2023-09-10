/*
 * https://www.acmicpc.net/problem/9506
 * 약수들의 합
 */

import java.util.Scanner;

public class N9506 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (true) {
			int n = in.nextInt();
			if (n == -1) {
				break;
			}

			// 문자열 확장시 매번 객체를 생성하지 않으려고 스트링빌더 사용
			StringBuilder str = new StringBuilder(n + " = ");
			int sum = 0;
			// 짝수인 경우 자신 제외 최대 약수는 절반 홀수인 경우는 그 이하이므로
			for (int i = 1; i <= n / 2; i++) {
				if (n % i == 0) {
					str.append(i + " + ");
					sum += i;
				}
			}

			if (n == sum) {
				System.out.println(str.delete(str.length() - 3, str.length()));
			} else {
				System.out.println(n + " is NOT perfect.");
			}

		}

		in.close();

		return;
	}
}
