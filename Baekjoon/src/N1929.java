/*
 * https://www.acmicpc.net/problem/1929
 * 소수 구하기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N1929 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split(" ");
		int m = Integer.parseInt(nums[0]);
		int n = Integer.parseInt(nums[1]);
		br.close();

		m = m == 1 ? 2 : m; // m이 1이랑 같은 경우 (n과 m도 같을 수 있으나 어차피 n이 더 작으면 동작하지 않는다)
		// boolean으로 숫자배열 표현 false로 초기화
		boolean[] numbers = new boolean[n];

		// 에라토스테네스의 체
		for (int i = 2; i <= (int) Math.sqrt(n); i++) { // 2부터 시작
			if (numbers[i - 1] == false) { // 제외되지 않은 숫자만
				for (int j = 2; j * i <= n; j++) { // 소수의 배수를 제외
					numbers[(i * j) - 1] = true;
				}
			}
		}

		StringBuilder str = new StringBuilder();
		for (int i = m; i <= n; i++) {
			if (numbers[i - 1] == false) {
				str.append(i + "\n");
			}
		}

		System.out.print(str);

		return;
	}

//	// 소수 구하는 메소드 1씩 증가하며 재귀호출 (시간초과로 미사용)
//	static boolean isSosu(int num, int trace) {
//		if (num == trace) {
//			return true;
//		} else if (num % trace == 0) {
//			return false;
//		}
//
//		return isSosu(num, trace + 1);
//	}
}
