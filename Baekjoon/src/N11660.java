/*
 * https://www.acmicpc.net/problem/11660
 * 구간 합 구하기 5
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11660 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int countN = Integer.parseInt(str.nextToken());
		int countM = Integer.parseInt(str.nextToken());

		long[][] sums = new long[countN + 1][countN + 1]; // 0번 인덱스에 초기값 0
		for (int i = 1; i <= countN; i++) { // 가로로 구간별 합을 저장한 배열
			str = new StringTokenizer(br.readLine());
			for (int j = 1; j <= countN; j++) {
				sums[i][j] = sums[i][j - 1] + Integer.parseInt(str.nextToken());
			}
		}

		StringBuilder result = new StringBuilder();
		while (countM > 0) {
			countM--;
			str = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(str.nextToken());
			int y1 = Integer.parseInt(str.nextToken());
			int x2 = Integer.parseInt(str.nextToken());
			int y2 = Integer.parseInt(str.nextToken());

			long sum = 0;
			for (int i = x1; i <= x2; i++) { // x축 범위만큼 반복
				sum += (sums[i][y2] - sums[i][y1 - 1]); // 합 배열을 이용
			}
			result.append(sum + "\n");
		}

		br.close();
		System.out.print(result);

		return;
	}
}
