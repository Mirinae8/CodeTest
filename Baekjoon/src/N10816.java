/*
 * https://www.acmicpc.net/problem/10816
 * 숫자 카드 2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.HashMap;

public class N10816 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int countN = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < countN; i++) {
			String str = strs[i];
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}

		int countM = Integer.parseInt(br.readLine());
		strs = br.readLine().split(" ");
		br.close();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < countM; i++) {
			String str = strs[i];
			if (map.containsKey(str)) {
				bw.write(map.get(str) + " ");
			} else {
				bw.write("0 ");
			}
		}

		bw.flush();
		bw.close();

		return;
	}
}
