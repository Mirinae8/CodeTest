/*
 * https://www.acmicpc.net/problem/11866
 * 요세푸스 문제 0
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class N11866 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		br.close();

		int n = Integer.parseInt(strs[0]);
		int k = Integer.parseInt(strs[1]);
		List<Integer> list = new LinkedList<Integer>();
		int[] arr = new int[10];
		for(int i = 1; i<=n;i++) {
			list.add(i);
		}
		
		StringBuilder str = new StringBuilder();
		Iterator<Integer> iter = list.iterator(); // 반복자
		while(!list.isEmpty()) {
			for(int i = 0; i < k -1 ;i++) {
				if(!iter.hasNext()) { // 끝이면 다시 처음부터
					iter = list.iterator(); // 원형태 구현
				}
				
				iter.next();
			}
			
			if(!iter.hasNext()) { // 끝이면 다시 처음부터
				iter = list.iterator(); // 원형태 구현
			}
			
			str.append(iter.next() + ", ");
			iter.remove();

		}

		str.delete(str.length() - 2, str.length());

		System.out.println("<" + str + ">");

		return;

	}
}
