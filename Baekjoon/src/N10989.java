/*
 * https://www.acmicpc.net/problem/10989
 * 수 정렬하기 3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N10989 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine()); // 리턴값 String 고정, 줄 넘김 단위로 끊김 (공백으로 구분시 추가 가공 필요), 예외 발생 가능
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		br.close();
		Arrays.sort(arr);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int num : arr) {
			bw.write(num + "");
			bw.newLine();
		}

		bw.flush();
		bw.close();

		return;
	}
}
