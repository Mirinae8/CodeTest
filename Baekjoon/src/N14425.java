/*
 * https://www.acmicpc.net/problem/14425
 * 문자열 집합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.HashSet;

public class N14425 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] counts = br.readLine().split(" ");
		int countN = Integer.parseInt(counts[0]);
		int countM = Integer.parseInt(counts[1]);

		Set<String> set = new HashSet<String>();
		for (int i = 0; i < countN; i++) {
			set.add(br.readLine());
		}

		int result = 0;
		for (int i = 0; i < countM; i++) {
			if (set.contains(br.readLine())) {
				result++;
			}
		}

		br.close();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(result + "");
		bw.flush();
		bw.close();

		return;
	}
}
