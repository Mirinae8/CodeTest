/*
 * https://www.acmicpc.net/problem/10815
 * 숫자 카드
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N10815 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int countN = Integer.parseInt(br.readLine());
		StringTokenizer tokenN = new StringTokenizer(br.readLine());
		int countM = Integer.parseInt(br.readLine());
		StringTokenizer tokenM = new StringTokenizer(br.readLine());
		br.close();

		Set<String> set = new HashSet<String>();
		while (tokenN.hasMoreTokens()) {
			set.add(tokenN.nextToken());
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < countM; i++) {
			bw.write(set.contains(tokenM.nextToken()) == true ? "1 " : "0 ");
		}
		
		bw.flush();
		bw.close();
		
		return;
	}
}
