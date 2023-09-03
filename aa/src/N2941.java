/**
 * https://www.acmicpc.net/problem/2941
 * 크로아티아 알파벳
 */
import java.util.Scanner;

public class N2941 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String alphabet = in.nextLine();
		int count = 0;
		
		for(int i = 0; i<alphabet.length();i++) {
			char c = alphabet.charAt(i);
			if(c == 'c') {
				if(i + 1 < alphabet.length() && alphabet.charAt(i + 1) == '=') {
					i += 1;
				} else if(i + 1 < alphabet.length() && alphabet.charAt(i + 1) == '-') {
					i += 1;
				}
			} else if (c == 'd') {
				// dz가 포함되는 경우 무조건 3번째 자리까지 체크하므로
				if(i + 2 < alphabet.length() && alphabet.charAt(i + 1) == 'z') {
					if(alphabet.charAt(i + 2) == '=') {
						i += 2;
					}
				} else if(i + 1 < alphabet.length() && alphabet.charAt(i + 1) == '-') {
					i += 1;
				}
				
			} else if (c == 'l') {
				if(i + 1 < alphabet.length() && alphabet.charAt(i + 1) == 'j') {
					i += 1;
				}
			} else if (c == 'n') {
				if(i + 1 < alphabet.length() && alphabet.charAt(i + 1) == 'j') {
					i += 1;
				}
			} else if (c == 's') {
				if(i + 1 < alphabet.length() && alphabet.charAt(i + 1) == '=') {
					i += 1;
				}
			} else if (c == 'z') {
				if(i + 1 < alphabet.length() && alphabet.charAt(i + 1) == '=') {
					i += 1;
				}
			}
			
			count++;
		}

		System.out.println(count);
		
		in.close();

		return;
	}
}
