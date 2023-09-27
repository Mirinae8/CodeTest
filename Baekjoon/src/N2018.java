/*
 * https://www.acmicpc.net/problem/2018
 * 수들의 합 5
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N2018 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		br.close();
		
		// 투 포인터 (메모리 초과로 합 배열 사용 불가)
		int result = 0; // 가지수를 저장하는 변수
		int start = 0;  // 아무것도 빼지 않는 0부터 시작
		int last = 0;
		int sum = 0;
		while(start < num) {
			if(sum == num) {
				result++;
				start++;
				sum = sum - start;
			} else if (sum > num) {
				start++;
				sum = sum - start;
			} else if (sum < num) {
				last++;
				sum = sum + last;
			}
		}
		
		System.out.println(result);
		
		return;
	}
}
