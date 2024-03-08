package Part2.BOJ1655;

import java.io.*;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class B1655_jjeonghak {

	private static final PriorityQueue<Integer> prefix = new PriorityQueue<>(Comparator.reverseOrder());
	private static final PriorityQueue<Integer> suffix = new PriorityQueue<>(Comparator.naturalOrder());

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(solution(input)).append("\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int solution(int input) {
		if (Objects.isNull(prefix.peek()) || prefix.peek() > input) {
			prefix.offer(input);
		} else {
			suffix.offer(input);
		}
		if (prefix.size() == suffix.size() + 2) {
			suffix.offer(prefix.poll());
		} else if (suffix.size() == prefix.size() + 1) {
			prefix.offer(suffix.poll());
		}
		return prefix.peek();
	}

}
