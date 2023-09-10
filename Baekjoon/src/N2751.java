/*
 * https://www.acmicpc.net/problem/2751
 * 수 정렬하기 2
 */

import java.util.Scanner;
import java.util.Arrays;

public class N2751 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int length = in.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = in.nextInt();
		}

		Arrays.sort(arr); // dual-pivot 퀵 정렬 (퀵 정렬은 빠르나 안전성이 떨어짐) Collections.sort(List<>) 를 사용할수도 있음
		StringBuilder str = new StringBuilder(); // println()으로 매번 출력시 시간 초과, 추가로 bufferReader 사용도 고려해볼만함
		for (int num : arr) {
			str.append(num + "\n");
		}
		
		System.out.println(str);

		in.close();

		return;
	}
}