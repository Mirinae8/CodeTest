/*
 * https://www.acmicpc.net/problem/2720
 * 세탁소 사장 동혁
 */

import java.util.Scanner;

public class N2720 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = scanner.nextInt();
		int[] inputs = new int[count];
		
		for(int i = 0; i < count; i++) {
			inputs[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < count; i++) {
			int[] results = new int[4];
			int cent = inputs[i];
			
			results[0] = cent/25;
			cent %= 25;
			results[1] = cent/10;
			cent %= 10;
			results[2] = cent/5;
			cent %= 5;
			results[3] = cent/1;
			
			System.out.println(results[0] + " " + results[1] + " " + results[2] + " " + results[3]);
		}
		
		
		scanner.close();
		
		return;
	}

}
