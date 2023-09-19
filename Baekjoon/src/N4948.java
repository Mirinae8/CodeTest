
/*
 * https://www.acmicpc.net/problem/4948
 * 베르트랑 공준
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class N4948 {
	public static void main(String[] args) throws Exception {
		// 1~123456 범위의 숫자가 주어지므로 해당 범위를 전체에서 소수를 미리 찾는다
		boolean[] numbers = new boolean[123456 * 2]; // 2n까지
		
		// 무조건 1보다 큰 수를 탐색하므로 1에 대한 예외처리는 필요없다
		// 에라토스테네스의 체
		for (int i = 2; i <= (int) Math.sqrt(numbers.length); i++) {
			if (numbers[i - 1] == false) {
				for (int j = 2; i * j <= numbers.length; j++) {
					numbers[i * j - 1] = true;
				}
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) { // 종료 의미
				br.close();
				bw.close();
				break;
			}

			int count = 0; // 범위내 소수의 숫자
			for (int i = num + 1; i <= 2 * num; i++) {
				if (numbers[i - 1] == false) {
					count++;
				}
			}

			bw.write(count + "");
			bw.newLine();
			bw.flush();
		}

		return;
	}
}
