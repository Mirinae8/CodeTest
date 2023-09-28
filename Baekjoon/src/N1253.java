
/*
 * https://www.acmicpc.net/problem/1253
 * 좋다
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class N1253 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		br.close();

		long[] nums = new long[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Long.parseLong(tokens.nextToken());
		}

		Arrays.sort(nums); // 정렬
		
		int result = 0;
		for (int i = 0; i < n; i++) { // 숫자가 중복되도 위치가 다르면 다른 수 이므로 전부 탐색
			long target = nums[i];
			int front = 0;
			int back = n - 1;
			while(front != back) {
				if(target == nums[front] + nums[back]) {
					if(front == i) { // 음수도 범위에 포함되므로 자기 자신과 더해서 자기 자신이 나올 수 있다
						front++;
					} else if (back == i) {
						back--;
					} else {
						result++;
						break;  // 두 수의 합으로 나타낼 수 있으면 탐색 종료
					}	
				} else if (target > nums[front] + nums[back]) {
					front++;
				} else if (target < nums[front] + nums[back]) {
					back--;
				}
			}
		}
		
		System.out.println(result);
		
		return;
	}
}
