/*
 * https://www.acmicpc.net/problem/17103
 * 골드바흐 파티션
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class N17103 {
	public static void main(String[] args) throws Exception {
		// 주어진 범위내의 소수를 찾는다
		boolean[] numbers = new boolean[1000000];

		// 에라토스테네스의 체
		for (int i = 2; i <= (int) Math.sqrt(numbers.length); i++) {
			if (numbers[i - 1] == false) {
				for (int j = 2; i * j <= numbers.length; j++) {
					numbers[i * j - 1] = true;
				}
			}
		}

		Set<Integer> set = new LinkedHashSet<Integer>(); // 소수만 담는 객체
		for (int i = 2; i <= numbers.length; i++) {
			if (numbers[i - 1] == false) {
				set.add(i);
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		int count = Integer.parseInt(br.readLine());
		while (count != 0) {
			count--;
			int result = 0;
			;
			int num = Integer.parseInt(br.readLine());
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				int x = iter.next();
				if (x > num / 2) { // 두 소수의 순서만 반대인 경우 제외하려고 목표 숫자의 절반까지만 동작
					break;
				}

				if (set.contains(num - x)) {
					result++;
				}
			}
			str.append(result + "\n");
		}

		br.close();

		System.out.println(str);

		return;
	}
}
