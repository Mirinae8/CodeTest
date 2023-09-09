/*
 * https://www.acmicpc.net/problem/2839
 * 설탕 배달
 */

import java.util.Scanner;

public class N2839 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int weight = in.nextInt();
		int count = weight;
		int five = weight / 5;  // 5로 나눈 정수 값 (최대 5가 몇개 들어갈 수 있는지)
		int three = weight / 3;  // 3로 나눈 정수 값 (최대 3가 몇개 들어갈 수 있는지)
		
		// 5와 3이 0개부터 최대 개수까지 들어가는 경우 중 가장 적은 개수를 찾는다
		for (int i = 0; i <= five; i++) {
			for (int j = 0; j <= three; j++) {
				int sum = i * 5 + j * 3;
				if (weight == sum) {
					count = count > i + j ? i + j : count;
				}
			}
		}

		if (count != weight) {
			System.out.println(count);
		} else {  // 그 어떤 경우도 목표 무개를 만족하지 못하는 경우
			System.out.println("-1");
		}

		in.close();

		return;
	}
}

class old {
//	int weight = in.nextInt();
//	int countFiveFirst = 0;
//	int countThreeFirst = 0;
//	boolean isFive = false;
//	boolean isThree = false;
//
////	while (weight >= 5) {
////		// 정확하게 드는게 우선이므로 5씩 빼면서
////		// 3으로 나누어 지는 경우가 있는지 찾는다
////		weight -= 5;
////		count++;
////		if (weight % 3 == 0) {
////			count += weight / 3;
////			weight = 0;
////		}
////	}
//
//	for (int i = weight; i >= 5;) {
//		// 정확하게 드는게 우선이므로 5씩 빼면서
//		// 3으로 나누어 지는 경우가 있는지 찾는다
//		i -= 5; // 처음부터 동작해야 하므로 (for문 증감식은 마지막에 동작)
//		countFiveFirst++;
//		if (i % 3 == 0 && i % 15 != 0) { // 3과 5의 최소공배수인 15의 배수는 5 로 나누는게 맞으므로 조건에서 제외
//			countFiveFirst += i / 3;
//			isFive = true;
//			break;
//		} else if (i == 0) {
//			isFive = true;
//		}
//	}
//
//	for (int i = weight; i >= 3;) {
//		// 정확하게 드는게 우선이므로 3씩 빼면서
//		// 5으로 나누어 지는 경우가 있는지 찾는다
//		i -= 3;
//		countThreeFirst++;
//		if (i % 5 == 0 && i % 15 != 0) { // 3과 5의 최소공배수인 15의 배수는 5 로 나누는게 맞으므로 조건에서 제외 (3일때는 필요없는 조건 같다)
//			countThreeFirst += i / 5;
//			isThree = true;
//			break;
//		} else if (i == 0) {
//			isThree = true;
//		}
//	}
//	
//	System.out.println(isFive + " | " + countFiveFirst + " | " + isThree + " | " + countThreeFirst);
//
//	// 5씩 빼면서 구한 값과 3씩 빼면서 구한 값 중에 적은 값을 사용 (정답이 없으면 있는 경우만 출력)
//	if (isFive && isThree) {
//		System.out.println(countFiveFirst < countThreeFirst ? countFiveFirst : countThreeFirst);
//	} else if (isFive || isThree) {
//		System.out.println(isFive == true ? countFiveFirst : countThreeFirst);
//	} else {
//		System.out.println("-1");
//	}
//
//	in.close();
//
//	return;
}
