/*
 * https://www.acmicpc.net/problem/18258
 * 큐 2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
//import java.util.List;
//import java.util.ArrayList;

public class N18258 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new Queue<Integer>();
		while (count > 0) {
			count--;
			String str = br.readLine();
			if (str.contains("push")) {
				queue.push(Integer.parseInt(str.substring(5, str.length())));

			} else if (str.equals("pop")) {
				bw.write((queue.isEmpty() ? "-1" : queue.pop()) + "\n");

			} else if (str.equals("size")) {
				bw.write(queue.size() + "\n");

			} else if (str.equals("empty")) {
				bw.write((queue.isEmpty() ? "1" : "0") + "\n");

			} else if (str.equals("front")){
				bw.write((queue.isEmpty() ? "-1" : queue.front()) + "\n");
			} else if (str.equals("back")){
				bw.write((queue.isEmpty() ? "-1" : queue.back()) + "\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
		
		return;
	}

	static class Queue<T> {
		final int MAX_SIZE = 2000000;
		T[] array;
		int front;
		int back;

		public Queue() {
			array = (T[]) new Object[MAX_SIZE];
			front = 0;
			back = 0;
		}

		public void push(T t) {
			array[back++] = t;
		}

		public T pop() {
			return array[front++];
		}

		public int size() {
			return back - front;
		}

		public boolean isEmpty() {
			return this.size() == 0 ? true : false;
		}

		public T front() {
			return array[front];
		}

		public T back() {
			return array[back - 1];
		}

		// 시간 초과로 인해 리스트로 구현을 포기하고 배열로 변경
//		static class Queue<T> {
//			List<T> list;
//
//			public Queue() {
//				list = new ArrayList<T>();
//			}
//
//			public void push(T t) {
//				list.add(t);
//			}
//
//			public T pop() {
//				return list.remove(0); // 처음 값 반환하고 삭제후 인덱스를 당긴다
//			}
//
//			public int size() {
//				return list.size();
//			}
//
//			public boolean isEmpty() {
//				return this.size() == 0 ? true : false;
//			}
//
//			public T front() {
//				return list.get(0);
//			}
//
//			public T back() {
//				return list.get(list.size() - 1);
//			}
	}
}
