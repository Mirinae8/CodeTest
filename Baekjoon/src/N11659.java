/*
 * https://www.acmicpc.net/problem/11659
 * 구간 합 구하기 4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N11659 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] counts = br.readLine().split(" ");
		int countN = Integer.parseInt(counts[0]);
		int countM = Integer.parseInt(counts[1]);
		String[] nums = br.readLine().split(" ");
		int[] sums = new int[countN]; // 구간 합을 저장하는 배열
		sums[0] = Integer.parseInt(nums[0]); // 인덱스 범위 벗어나는것 방지
		for (int i = 1; i < countN; i++) {
			sums[i] = sums[i - 1] + Integer.parseInt(nums[i]) ;
		}
		
		StringBuilder result = new StringBuilder();
		while(countM > 0) { // 지정된 구간의 합을 구한다
			countM--;
			String[] ranges =  br.readLine().split(" ");
			int i = Integer.parseInt(ranges[0]);
			int j = Integer.parseInt(ranges[1]);
			result.append(i == 1 ? sums[j-1] : sums[j-1] - sums[i-2]); // 첫번째 원소부터 구간이 시작되면 빼지않는다
			result.append("\n");
		}
		
		br.close();
		System.out.print(result);
		return;
	}
}
