/*
 * https://www.acmicpc.net/problem/1316
 * 그룹 단어 체커
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class N1316 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		int result = 0; // 그룹 단어의 개수 저장
		
		while(count > 0) {
			count--;

//			String word = in.nextLine(); Scanner.newLine() 메소드 사용시 처음 숫자를 입력했을때 있던 공백을 불러와서 개수가 초과된다
			String word = in.next();
			boolean isGroup = true;
			Set<Character> set = new HashSet<Character>();
			char backChar = 1; // 이전 글자 저장
			for(char c : word.toCharArray()) {
				if(backChar != c && set.contains(c)) {
					isGroup = false;
					break;
				} else {
					backChar = c;
					set.add(c);
				}
			}
			
			if(isGroup == true) {
				result++;
			}
			
			set.clear();
			
		}
		
		System.out.println(result);
		
		in.close();
		
		return;
	}
}
