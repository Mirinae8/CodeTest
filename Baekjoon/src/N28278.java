/*
 * https://www.acmicpc.net/problem/28278
 * 스택 2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class N28278 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		while (count > 0) {
			count--;
			String command = br.readLine();
			if(command.charAt(0) == '1') { // 스택에 삽입하는 명령
				stack.push(Integer.parseInt(command.substring(2,command.length())));
			} else if (command.equals("2")) {
				if(stack.length() != 0) {
					bw.write(stack.pop() + "");
					bw.newLine();
				} else {
					bw.write("-1");
					bw.newLine();
				}
			} else if (command.equals("3")) {
				bw.write(stack.length() + "");
				bw.newLine();
			} else if (command.equals("4")) {
				if(stack.length() != 0) {
					bw.write("0");
					bw.newLine();
				} else {
					bw.write("1");
					bw.newLine();
				}
			} else if (command.equals("5")) {
				if(stack.length() != 0) {
					bw.write(stack.top() + "");
					bw.newLine();
				} else {
					bw.write("-1");
					bw.newLine();
				}
			}
//			bw.flush(); 시간 초과되서 지움
		}
		
		br.close();
		bw.flush();
		bw.close();

		return;
	}

	static class Stack<T> {
		private final int MAX_SIZE = 1000000;
		private T[] arr;
		private int pointer;

		@SuppressWarnings("unchecked")
		public Stack() {
			arr = (T[]) new Object[MAX_SIZE]; // 제네릭 타입의 배열 생성은 불가하다
			pointer = -1;
		}

		public void push(T num) {
			arr[++pointer] = num;
		}

		public T pop() {
			return arr[pointer--];
		}

		public int length() {
			return pointer + 1;
		}
		
		public T top() {
			return arr[pointer];
		}
	}
}
