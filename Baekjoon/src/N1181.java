/*
 * https://www.acmicpc.net/problem/1181
 * 단어 정렬
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

public class N1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<String>(); // 같은 문자 중복 제거위해 set 사용
		for (int i = 0; i < count; i++) {
			set.add(br.readLine());
		}

		br.close();
//		Word[] words = new Word[set.size()];
		String[] strs = set.toArray(new String[set.size()]);
//		for (int i = 0; i < set.size(); i++) {
//			words[i] = new Word(strs[i]);
//		}

		Arrays.sort(strs,new DicComparator());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		for (Word word : words) {
//			bw.write(word.toString());
//			bw.newLine();
//		}
		for (String str : strs) {
			bw.write(str);
			bw.newLine();
		}

		bw.flush();
		bw.close();

		return;

	}
	
	// 비교메소드만 재정의하는 방법
	static class DicComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if (o1.length() > o2.length()) {
				return 1;
			} else if (o1.length() < o2.length()) {
				return -1;
			}

			// 길이가 같은 경우 사전 순으로 (
			for (int i = 0; i < o1.length(); i++) {
				if (o1.charAt(i) > o2.charAt(i)) {
					return 1;
				} else if (o1.charAt(i) < o2.charAt(i)) {
					return -1;
				}
			}

			return 0;
		}

	}
	
	// 새로운 클래스를 만들어 비교메소드를 재정의 하는 방법
//	static class Word implements Comparable<Word> {
//		String str;
//
//		public Word(String str) {
//			this.str = str;
//		}
//
//		public String toString() {
//			return this.str;
//		}
//
//		@Override
//		public int compareTo(Word word) {
//			String other = word.str;
//			if (str.length() > other.length()) {
//				return 1;
//			} else if (str.length() < other.length()) {
//				return -1;
//			}
//
//			// 길이가 같은 경우 사전 순으로 (
//			for (int i = 0; i < str.length(); i++) {
//				if (str.charAt(i) > other.charAt(i)) {
//					return 1;
//				} else if (str.charAt(i) < other.charAt(i)) {
//					return -1;
//				}
//			}
//
//			return 0;
//		}
//	}
}
