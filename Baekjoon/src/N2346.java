/*
 * https://www.acmicpc.net/problem/2346
 * 풍선 터뜨리기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

public class N2346 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		Deque<Balloon> deque = new ArrayDeque<Balloon>(); // LinkedList 사용시 메모리 초과 ArrayDeque가 더 메모라 적게 사용
		for (int i = 0; i < count; i++) {
			deque.add(new Balloon(i + 1, Integer.parseInt(strs[i])));
		}
		
		br.close();
		StringBuilder result = new StringBuilder();
		Balloon balloon = deque.pollFirst();
		result.append(balloon.num + " ");
		int value = balloon.value;
		while(!deque.isEmpty()) {
			if(value > 0) {
				for(int i = 0;i<value - 1;i++) { // 정방향 이동
					deque.addLast(deque.pollFirst());  // 끝에 붙임
				}
				balloon = deque.pollFirst();
				result.append(balloon.num + " ");
				value = balloon.value;
			} else{ // 반대 방향 이동
				for(int i = 0;i<(-value) - 1;i++) {
					deque.addFirst(deque.pollLast());  // 시작에 붙임
				}
				balloon = deque.pollLast();
				result.append(balloon.num + " ");
				value = balloon.value;
			}
		}
		System.out.println(result);
		
		return;

	}

	static class Balloon {
		int num;
		int value;

		public Balloon(int num, int value) {
			this.num = num;
			this.value = value;
		}
	}

}
