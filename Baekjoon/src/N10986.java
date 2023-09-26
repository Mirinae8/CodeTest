/*
 * https://www.acmicpc.net/problem/10986
 * 나머지 합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N10986 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] counts = br.readLine().split(" ");
		int countN = Integer.parseInt(counts[0]);
		int m = Integer.parseInt(counts[1]);

		long[] sums = new long[countN + 1]; // 0번 인덱스를 비우려고
		String[] nums = br.readLine().split(" ");
		br.close();
		for (int i = 1; i <= countN; i++) { // 합 배열 생성
			sums[i] = sums[i - 1] + Integer.parseInt(nums[i - 1]);
		}

//		for (int i = 1; i <= countN; i++) { // 합 배열을 나머지 합 배열로 변경
//			sums[i] = sums[i] % m;
//		}

		long[] remainders = new long[m]; // 같은 나머지를 같는 합 배열 원소를 세는 배열
		long result = 0; // 결과를 센다 (int 형일때 오답처리 되었다)
		for (int i = 1; i <= countN; i++) { // 0번 인덱스가 비어있으므로
			int remainder = (int) (sums[i] % m);
			if (remainder == 0) {
				result++;
			}
			remainders[remainder]++;
		}

		// 조합(nCr) 을 사용해 나머지가 같은 원소중 두 가지를 고르는 경우의 수를 찾는다
		for (long remainder : remainders) {
			if (remainder > 1) { // 나머지가 두 개 이상 존재할 때
				result += remainder * (remainder - 1) / 2; // r이 2로 고정이므로 n * n-1
			}
		}

		System.out.print(result);

		return;
	}
}