/*
 * https://www.acmicpc.net/problem/1193
 * 분수찾기
 */
import java.util.Scanner;

public class N1193 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int targetNum = in.nextInt();
		
//		String[] array = new String[targetNum]; // 배열에 채우는 방식은 메모리 초과 필요한 값까지만 계산하도록 변경
		
//		int sum = 2; // 분모 분자 총 합
//		int bunja = 1; // 분자, 1씩 증가하거나 감소함
		String result = null;
		
		// 단계적 생성시 시간초과
//		for(int i = 0; i < targetNum; i++) {
//			if(sum % 2 == 0) { // 분모 분자 총합이 짝수일 경우 분자는 감소
//				result = (sum - bunja)+ "/" + bunja;
//			} else { // 분모 분자 총합이 홀수일 경우 분자는 증가
//				result = bunja + "/" + (sum - bunja);
//			}
//			
//			bunja++;
//			if(sum == bunja) {
//				sum++;
//				bunja = 1;
//			}
//		}
		
		int level = 1; // 배열의 대각선 순번 1씩 증가
		int count = 1; // 현재 대각선의 가장 작은 값 저장
		int bunja = 0; // 현재 대각선에서 몇번째 위치인지 저장
		while(true) {
			// 현재 대각선이 몇번 째인지 찾는다
			if(targetNum >= count && targetNum < count + level) {
				bunja = targetNum - count + 1;
				break;
			}
			count += level;
			level++;
		}
		
		// 대각선 순번이 짝수냐 홀수냐에 따라 시작 위치가 달라진다
		// 대각선 
		if(level % 2 == 0) {
			result = bunja + "/" + (level + 1 - bunja);
		}
		else {
			result = (level + 1 - bunja)+ "/" + bunja;
		}
		
		System.out.println(result);
		
		in.close();
		
		return;
	}
}
