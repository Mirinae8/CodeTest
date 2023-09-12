/*
 * https://www.acmicpc.net/problem/10814
 * 나이순 정렬
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10814 {
	public static void main(String[] strs) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		User[] users = new User[count];
		for (int i = 0; i < count; i++) {
			users[i] = new User(br.readLine(), i);
		}

		br.close();
		Arrays.sort(users);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (User user : users) {
			bw.write(user.toString());
			bw.newLine();
		}

		bw.flush();
		bw.close();

		return;

	}

	static class User implements Comparable<User> {
		int age;
		String name;
		int order; // 가입순서를 저장

		public User(String str, int order) {
			StringTokenizer st = new StringTokenizer(str); // 공백단위로 자르기 위해
			this.age = Integer.parseInt(st.nextToken());
			this.name = st.nextToken();
			this.order = order;
		}

		public String toString() {
			return age + " " + name;
		}

		@Override
		public int compareTo(User obj) {
			if (this.age > obj.age) {
				return 1;
			} else if (this.age < obj.age) {
				return -1;
			} else { // 나이가 같으면 가입순서대로
				return this.order > obj.order ? 1 : -1;
			}
		}
	}
}
