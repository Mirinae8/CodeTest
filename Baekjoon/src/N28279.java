/*
 * https://www.acmicpc.net/problem/28279
 * 덱 2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class N28279 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new Deque<Integer>();
		while (count > 0) {
			count--;
			String str = br.readLine();
			if (str.charAt(0) == '1') {
				int num = Integer.parseInt(str.substring(2, str.length()));
				deque.addFirst(num);

			} else if (str.charAt(0) == '2') {
				int num = Integer.parseInt(str.substring(2, str.length()));
				deque.addLast(num);

			} else if (str.equals("3")) {
				Integer num = deque.pollFirst(); // null 반환 받기위해 래퍼클래스로
				bw.write((num != null ? num : -1) + "\n");

			} else if (str.equals("4")) {
				Integer num = deque.pollLast(); // null 반환 받기위해 래퍼클래스로
				bw.write((num != null ? num : -1) + "\n");
			} else if (str.equals("5")) {
				bw.write(deque.size() + "\n");
			} else if (str.equals("6")) {
				bw.write(deque.isEmpty() + "\n");
			} else if (str.equals("7")) {
				Integer num = deque.peekFirst(); // null 반환 받기위해 래퍼클래스로
				bw.write((num != null ? num : -1) + "\n");
			} else if (str.equals("8")) {
				Integer num = deque.peekLast(); // null 반환 받기위해 래퍼클래스로
				bw.write((num != null ? num : -1) + "\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();

		return;
	}

	static class Deque<T> {
		class Node<T> {
			T value;
			Node<T> next;
			Node<T> before;

			public Node(T t) {
				value = t;
				next = null;
				before = null;
			}

			public Node<T> getFirst() {
				if (before == null) {
					return this;
				} else {
					return before.getFirst();
				}
			}

			public Node<T> getLast() {
				if (next == null) {
					return this;
				} else {
					return next.getLast();
				}
			}
		}

		Node<T> first;
		Node<T> last;

		public Deque() {
			first = null;
			last = null;
		}

		public void addFirst(T t) {
			Node<T> node = new Node<T>(t);
			if (first != null) {
				first.before = node;
			}
			node.next = first;
			first = node;
			if(last == null) {
				last = node;
			}
		}

		public void addLast(T t) {
			Node<T> node = new Node<T>(t);
			if (last != null) {
				last.next = node;
			}
			node.before = last;
			last = node;
			if(first == null) {
				first = node;
			}
		}

		public T pollFirst() {
			if (first == null) {
				return null;
			}
			Node<T> node = first;
			first = node.next;
			if (first != null) {
				first.before = null;
			} else {
				last = null;
			}

			return node.value;
		}

		public T pollLast() {
			if (first == null) {
				return null;
			}
			Node<T> node = last;
			last = node.before;
			if (last != null) {
				last.next = null;
			}else {
				first = null;
			}

			return node.value;
		}

		public int size() {
			Node<T> node = first;
			int size = 0;
			while (node != null) {
				node = node.next;
				size++;
			}

			return size;
		}

		public int isEmpty() {
			return first == null ? 1 : 0;
		}

		public T peekFirst() {
			if (first == null) {
				return null;
			}

			return first.value;
		}

		public T peekLast() {
			if (first == null) {
				return null;
			}

			return last.value;
		}
	}
}
