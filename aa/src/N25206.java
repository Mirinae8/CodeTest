/*
 * https://www.acmicpc.net/problem/25206
 * 너의 평점은
 */

import java.util.Scanner;

public class N25206 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int total = 0; // 학점의 총합
		double score = 0.0; // 학점x과목평점의 합
		for(int i = 0; i<20; i++) {
			in.next(); // 과목명을 필요없다
			double x = Double.parseDouble(in.next());
			double y = getGrade(in.next()); 
			// p 등급은 제외
			if(y < 0) {
				continue;
			}
			
			total += x;
			score += x*y;
		}
		
		System.out.println(score / total);
		
		in.close();
		
		return;
		
	}
	
	private static double getGrade(String str) {
		double grade = 0.0;
		switch(str) {
			case "A+":
				grade = 4.5;
				break;
			case "A0":
				grade = 4.0;
				break;
			case "B+":
				grade = 3.5;
				break;
			case "B0":
				grade = 3.0;
				break;
			case "C+":
				grade = 2.5;
				break;
			case "C0":
				grade = 2.0;
				break;
			case "D+":
				grade = 1.5;
				break;
			case "D0":
				grade = 1.0;
				break;
			case "F":
				grade = 0.0;
				break;
			case "P":
				grade = -1.0;
				break;
		}
		
		return grade;
	}
}
