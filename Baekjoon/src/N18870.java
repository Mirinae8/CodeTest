/*
 * https://www.acmicpc.net/problem/18870
 * 좌표 압축
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class N18870 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		br.close();
		Dot[] dots = new Dot[count];
		for (int i = 0; i < count; i++) {
			dots[i] = new Dot(token.nextToken(), i);
		}

		Arrays.sort(dots); // 좌표 순서로 정렬

		int prevX = Integer.MIN_VALUE; // 주어지는 좌표 범위보다 더 작은 정수형 최소값
		int prevNum = -1; // 첫 루프에서 무조건 증가되야 하므로
		for (int i = 0; i < count; i++) {
			if (dots[i].x > prevX) {
				prevNum++;
				dots[i].setXPrime(prevNum);
				prevX = dots[i].x;
			} else { // 정렬된 상태이므로 이전보다 크거나 같은 경우만 존재한다
				dots[i].setXPrime(prevNum);
			}
		}

		Arrays.sort(dots, new DotComparator()); // 입력 순서로 정렬 (다른 풀이로 이미 정렬된 값이므로 이분 검색(o = log n)을 이용할 수 있다.

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (Dot dot : dots) {
			bw.write(dot.toString());
		}

		bw.flush();
		bw.close();

		return;
	}

	static class Dot implements Comparable<Dot> {
		int x; // 좌표
		int xPrime; // 압축 좌표
		int num; // 입력 순서

		public Dot(String str, int num) {
			this.x = Integer.parseInt(str);
			this.num = num;
		}

		public void setXPrime(int num) {
			this.xPrime = num;
		}

		public String toString() {
			return xPrime + " ";
		}

		@Override
		public int compareTo(Dot obj) {
			if (x > obj.x) {
				return 1;
			} else if (x < obj.x) {
				return -1;
			}

			return 0;
		}
	}

	static class DotComparator implements Comparator<Dot> {

		@Override
		public int compare(Dot o1, Dot o2) {
			if (o1.num > o2.num) {
				return 1;
			} else { // num 이 같은 경우는 존재하지 않는다
				return -1;
			}
		}
	}
}
