/*
 * https://www.acmicpc.net/problem/13241
 * 최소공배수
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N13241 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		long a = Long.parseLong(tokens.nextToken());
		long b = Long.parseLong(tokens.nextToken());

		if (a > b) { // a를 더 작거나 같은 값으로 변경
			long temp = b;
			b = a;
			a = temp;
		}
		long result = calc(a, b);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(result + "");
		bw.flush();
		bw.close();

		return;
	}

	// 재귀호출
	static long calc(long a, long b) {
		if (a == 1) {
			return b; // 1이면 어차피 a * b가 b이므로
		}

		long num = 2;
		boolean is = false;
		while (num <= a) {
			if (a % num == 0 && b % num == 0) {
				a = a / num;
				b = b / num;
				is = true;
				break;
			}
			num++;
		}

		if (is != true) { // 공약수가 없는 경우
			return a * b;
		}

		// 공약수 * 소수
		return num * calc(a, b);
	}
}
