/*
 * https://www.acmicpc.net/problem/4949
 * 균형잡힌 세상
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class N4949 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		while (!str.equals(".")) {
			Stack<Character> stack = new Stack<Character>(); // 가장 최근에 넣은 괄호를 확인해야 하므로 스택 사용
			boolean isBalanced = true;
			for (char c : str.toCharArray()) {
				if(!isBalanced) {
					break;
				}
				switch (c) {
				case '(':
					stack.push(c);
					break;
				case ')':
					if (stack.size() != 0 && stack.peek() == '(') {
						stack.pop();
					} else {
						isBalanced = false;
					}
					break;
				case '[':
					stack.push(c);
					break;
				case ']':
					if (stack.size() != 0 && stack.peek() == '[') {
						stack.pop();
					} else {
						isBalanced = false;
					}
					break;
				}
			}
			
			if(stack.size() != 0) { // 스택에 처리되지 않은 괄호가 남아있으면 불균형 한 것
				isBalanced = false;
			}
			
			bw.write(isBalanced ? "yes" : "no");
			bw.newLine();
			str = br.readLine();
		}

		br.close();
		bw.flush();
		bw.close();
		
		return;
	}
}
