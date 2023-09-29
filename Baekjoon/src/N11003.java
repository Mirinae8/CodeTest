/*
 * https://www.acmicpc.net/problem/11003
 * 최솟값 찾기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.ArrayDeque;

public class N11003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		int countN = Integer.parseInt(strs[0]);
		int countL = Integer.parseInt(strs[1]);
		strs = br.readLine().split(" ");
		br.close();

		Deque<Node> deque = new ArrayDeque<Node>(countL);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // StringBuilder를 사용해 out.print()로 출력했으나 시간초과되서 스트림 출력으로 변경
		for (int i = 0; i < countN; i++) {
			int num = Integer.parseInt(strs[i]);
			Node node = new Node(i, num);

			while (deque.size() != 0 && deque.peekLast().value > num) { // 새로 들어오는 값보다 큰 값은 최소값이 될 수 없으므로 제거
				deque.removeLast();
			}

			if (deque.size() != 0 && deque.peekFirst().index <= i - countL) {
				deque.removeFirst();
			}

			deque.addLast(node);

			bw.write(deque.peekFirst().value + " ");
		}

		// 시간 초과로 정렬 없이 찾도록 수정
//		Integer lowest = null;
//		Deque<Integer> targets = new ArrayDeque<Integer>(countL);
//		StringBuilder result = new StringBuilder();
//		for (int i = 0; i < countN; i++) {
//			if (targets.size() == countL) {
//				Integer first = targets.pollFirst();
//				if (first == lowest) {  // 나간 값이 최소값과 같으면 재정렬 필요
//					lowest = null;
//				}
//			}
//
//			Integer last = nums[i];
//			if (lowest != null && last < lowest) {  // 들어온 값이 최소값보다 작으면 재정렬 필요
//				lowest = last;
//			}
//			targets.addLast(last);
//
//			if (lowest == null || targets.size() < countL) {  // 특정 조건마다 정렬해서 최소값을 찾는다
//				Integer[] temp = targets.toArray(new Integer[targets.size()]);
//				Arrays.sort(temp);
//				lowest = temp[0];
//			}
//
//			result.append(lowest + " ");
//		}

		bw.flush();
		bw.close();

		return;
	}

	static class Node {
		int index;
		int value;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}
