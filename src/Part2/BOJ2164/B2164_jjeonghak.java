package Part2.BOJ2164;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class B2164_jjeonghak {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		sb.append(solution(n));
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int solution(int n) {
		Queue<Integer> q = new LinkedList<>();
		IntStream.range(1, n + 1).forEach(q::offer);

		boolean flag = false;
		while (q.size() > 1) {
			int front = q.poll();
			if (flag) {
				q.offer(front);
			}
			flag = !flag;
		}
		return q.poll();
	}

}

