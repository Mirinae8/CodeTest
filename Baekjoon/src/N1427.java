/*
 * https://www.acmicpc.net/problem/1427
 * 소트인사이드
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N1427 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();

		int count = str.length();
		int[] numbers = new int[count];
		for (int i = 0; i < count; i++) {
			numbers[i] = Integer.parseInt(str.charAt(i) + "");
		}

		Arrays.sort(numbers); // 오름차순 정렬 Collections.reverseOrder() 를 인자로 받아 내림차순 정렬하려면 입력 배열이 객체 배열(String[] 같은 compareTo()가 정의된 객체의 배열)이여야 한다

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = count - 1; i >= 0; i--) { // 내림차순으로 출력되도록 순서 반대로
			bw.write(numbers[i] + "");
		}

		bw.flush();
		bw.close();

		return;
	}
}
