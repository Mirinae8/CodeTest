/*
 * https://www.acmicpc.net/problem/2485
 * 가로수
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2485 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[] nums = new int[count];
		for (int i = 0; i < count; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		Arrays.sort(nums);
		int gcd = nums[1] - nums[0];
		for (int i = 2; i < nums.length; i++) {
			// 가로수 간격끼리의 최대공약수로 가로수를 심어야 한다
			gcd = gcd(gcd, nums[i] - nums[i - 1]);
			if (gcd == 1) {
				break;
			}
		}
		
		int length = nums[nums.length - 1] - nums[0]; // 가로수 사이의 거리 (가로수를 전부 심었을때 -1)
		int total = length / gcd + 1; // 일정 간격별로 심어진 전체 가로수의 숫자

		System.out.println(total - count);
		
		return;
	}
	
	// 최대공약수를 구한다
	static int gcd(int a, int b) {
		if (b > a) {
			return gcd(b, a);
		}

		return b == 0 ? a : gcd(b, a % b);
	}
}