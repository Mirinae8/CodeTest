/*
 * https://www.acmicpc.net/problem/11478
 * 서로 다른 부분 문자열의 개수
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.HashSet;

public class N11478 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();
		Set<String> set = new HashSet<String>(); // 중복 제거 위해
		for (int i = 1; i <= str.length(); i++) { // i는 몇자리 단위로 끊을지 나타낸다
			for (int j = 0; j + i <= str.length(); j++) { // j는 실제 인덱스
				set.add(str.substring(j, j + i));
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(set.size() + "");
		bw.flush();
		bw.close();

		return;
	}
}
