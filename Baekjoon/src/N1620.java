/*
 * https://www.acmicpc.net/problem/1620
 * 나는야 포켓몬 마스터 이다솜
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.HashMap;

public class N1620 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] counts = br.readLine().split(" ");
		int countN = Integer.parseInt(counts[0]);
		int countM = Integer.parseInt(counts[1]);

//		Set 사용시 순서를 찾는데 문제가 있고 Map을 하나만 사용시 속도 문제가 있어서 Map을 두 개 사용 (배열 하나와 맵 하나를 사용하는 방식이 제일 이상적인것으로 보임)
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<Integer, String> map2 = new HashMap<Integer, String>();
		for (int i = 0; i < countN; i++) {
			String str = br.readLine();
			map1.put(str, i + 1);
			map2.put(i+1, str);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < countM; i++) {
			String str = br.readLine();
			if (map1.containsKey(str)) {
				bw.write(map1.get(str) + "");
				bw.newLine();
			} else {
				bw.write(map2.get(Integer.parseInt(str)));
				bw.newLine();
			}
		}
		br.close();
		bw.flush();
		bw.close();

		return;
	}
}
