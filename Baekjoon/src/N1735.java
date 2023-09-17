/*
 * https://www.acmicpc.net/problem/1735
 * 분수 합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class N1735 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split(" ");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		nums = br.readLine().split(" ");
		br.close();
		// 우선 두 분수를 합친다
		a = a * Integer.parseInt(nums[1]) + b * Integer.parseInt(nums[0]);
		b = b * Integer.parseInt(nums[1]);
		// 합쳐진 분수에서 분모와 분자의 최대공약수를 구한 후 나누어 기약분수로 만들려고 한다
		int num = calc(a, b);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(a / num + " " + b / num);
		bw.flush();
		bw.close();
		
		return;
	}
	
	// 재귀호출로 최대공약수 구하는 함수
	static int calc(int a, int b) {
		if (a == 1 || b == 1) {
			return 1;
		}

		int num = 2;
		final int max = a > b ? a : b;
		boolean isOk = false;
		while (num <= max) { // 두 수가 같은 경우 공약수가 max와 같은 수 있다
			if (a % num == 0 && b % num == 0) {
				a = a / num;
				b = b / num;
				isOk = true;
				break;
			}
			num++;
		}

		if (isOk != true) {
			return 1;
		}

		return num * calc(a, b);
	}
}
