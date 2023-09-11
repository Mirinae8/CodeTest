/*
 * https://www.acmicpc.net/problem/11650
 * 좌표 정렬하기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N11650 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		Dot[] dots = new Dot[count];

		for (int i = 0; i < count; i++) {
			dots[i] = new Dot(br.readLine());
		}

		br.close();
		Arrays.sort(dots);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (Dot dot : dots) {
			bw.write(dot.toString());
			bw.newLine();
		}

		bw.flush();
		bw.close();

		return;
	}
}

// static인 메인에서 사용하려고 따로 클래스 만듬
// 기존 클래스의 이너 클래스로 만들고 static class로 정의해도 된다
class Dot implements Comparable<Dot> {
	int x;
	int y;

	public Dot(String str) {
		String[] strs = str.split(" ");
		x = Integer.parseInt(strs[0]);
		y = Integer.parseInt(strs[1]);
	}
	
	// Arrays.sort()가 Comparable<T> 인터페이스의 compareTo() 메소드로 비교해 정렬하므로
	@Override
	public int compareTo(Dot o) {
		if (this.x > o.x) {
			return 1;
		} else if (this.x == o.x) {
			if (this.y > o.y) {
				return 1;
			} else if (this.y == o.y) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}
