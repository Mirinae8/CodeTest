/*
 * https://www.acmicpc.net/problem/1940
 * 주몽
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1940 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		br.close();

		int[] nums = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(strs[i - 1]);
		}

		Arrays.sort(nums);

		// 투 포인터
		int start = 1;
		int last = n;
		int result = 0;
		while (start != last) {
			if (nums[last] + nums[start] == m) {
				result++;
				start++;
			} else if (nums[last] + nums[start] < m) {
				start++;
			} else if (nums[last] + nums[start] > m) {
				last--;
			}
		}

		System.out.println(result);

		return;
	}
}
