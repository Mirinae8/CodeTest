/*
 * https://www.acmicpc.net/problem/2745
 * 진법 변환
 */
import java.util.Scanner;

public class N2745 {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		
//		String str = in.nextLine(); // in.next() 쓰면 공백 단위로 끊김
		String[] strs = new String[2];
		strs[0] = in.next();
		strs[1] = in.next();
		
		
		System.out.println(Integer.parseInt(strs[0], Integer.parseInt(strs[1])));
		
		return;
	}

}