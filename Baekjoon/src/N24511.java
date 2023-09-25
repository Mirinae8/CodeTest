/*
 * https://www.acmicpc.net/problem/24511
 * queuestack
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.ArrayDeque;

public class N24511 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		String[] types = br.readLine().split(" ");
		String[] elements = br.readLine().split(" ");
		int num = Integer.parseInt(br.readLine());
		String[] inserts = br.readLine().split(" ");
		br.close();
		
		Deque<String> deque = new ArrayDeque<String>();
		for (int i = 0; i < count; i++) {
			// 스택 자료구조는 영향을 미치지 않는다
			if(types[i].equals("0")) { 
				deque.add(elements[i]);
			}
		}
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < num; i++) {
			deque.addFirst(inserts[i]);
			result.append(deque.pollLast() + " ");
		}
		
		// 문제 예시를 구현해보았으나 시간초과
//		QueueStack[] qss = new QueueStack[count];
//		for (int i = 0; i < count; i++) {
//			qss[i] = new QueueStack(Integer.parseInt(types[i]));
//			qss[i].add(Integer.parseInt(elements[i]));
//		}
//
//		StringBuilder result = new StringBuilder();
//		for (int i = 0; i < num; i++) {
//			int value = Integer.parseInt(inserts[i]);
//			for (QueueStack qs : qss) {
//				qs.add(value);
//				value = qs.pop();
//			}
//			result.append(value + " ");
//		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(result.toString());
		bw.flush();
		bw.close();

		return;
	}

	// 문제 예시를 구현해보았으나 시간초과
//	static class QueueStack {
//		Integer front;
//		Integer back;
//		int type;
//
//		public QueueStack(int type) {
//			this.type = type;
//		}
//
//		public void add(int num) {
//			if (front == null) { // 자료구조에 상관없이 앞쪽부터 채운다
//				front = num;
//			} else {
//				back = num;
//			}
//		}
//
//		public int pop() {
//			if (type == 0) { // 큐이므로 앞에 원소를 빼고 원소를 이동시킨다
//				int temp = front;
//				front = back;
//				back = null;
//				return temp;
//			} else { // 스택이므로 마지막 원소만 뺀다
//				int temp;
//				if (back != null) {
//					temp = back;
//					back = null;
//				} else {
//					temp = front;
//					front = null;
//				}
//				return temp;
//			}
//		}
//	}
}
