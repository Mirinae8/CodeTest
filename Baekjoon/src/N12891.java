/*
 * https://www.acmicpc.net/problem/12891
 * DNA 비밀번호
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N12891 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nums = br.readLine().split(" ");
		int countS = Integer.parseInt(nums[0]);
		int countP = Integer.parseInt(nums[1]);
		char[] chars = br.readLine().toCharArray();
		nums = br.readLine().split(" ");
		int countA = Integer.parseInt(nums[0]);
		int countC = Integer.parseInt(nums[1]);
		int countG = Integer.parseInt(nums[2]);
		int countT = Integer.parseInt(nums[3]);

		int targetA = 0;
		int targetC = 0;
		int targetG = 0;
		int targetT = 0;
		int result = 0;

		for (int i = 0; i < countS; i++) { // 전 범위를 한 번씩 탐색해야 한다
			if (chars[i] == 'A') {
				targetA++;
			} else if (chars[i] == 'C') {
				targetC++;
			} else if (chars[i] == 'G') {
				targetG++;
			} else if (chars[i] == 'T') {
				targetT++;
			}

			if (i > countP - 1) { // 구간을 벗어난 원소 카운팅 제거
				if (chars[i - countP] == 'A') {
					targetA--;
				} else if (chars[i - countP] == 'C') {
					targetC--;
				} else if (chars[i - countP] == 'G') {
					targetG--;
				} else if (chars[i - countP] == 'T') {
					targetT--;
				}
			}
			
			// 구간을 만족했을 때 각 목표에 일치하는지
			if (i >= countP - 1 && targetA >= countA && targetC >= countC && targetG >= countG && targetT >= countT) {
				result++;
			}
		}

		// 시간 초과로 목표 문자열에 삽입,삭제 되는 문자만 검사하도록 변경
//		while (back <= countS) { // substring 메소드 특성상 끝은 문자열의 길이와 같아야 한다
//			String target = str.substring(front, back); // 시작은 포함 끝은 미포함
//			front++;
//			back++;
//			if (countA <= (int) target.chars().filter(i -> String.valueOf((char) i).equals("A")).count()) { // Stream을
//																											// 사용해 특정
//																											// 문자열 개수 반환
//				continue;
//			}
//
//			if (countC <= (int) target.chars().filter(i -> String.valueOf((char) i).equals("C")).count()) {
//				continue;
//			}
//
//			if (countG <= (int) target.chars().filter(i -> String.valueOf((char) i).equals("G")).count()) {
//				continue;
//			}
//
//			if (countT <= (int) target.chars().filter(i -> String.valueOf((char) i).equals("T")).count()) {
//				continue;
//			}
//
//			result++;
//		}

		System.out.println(result);

		return;
	}
}
