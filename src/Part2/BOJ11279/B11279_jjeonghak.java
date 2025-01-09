package Part2.BOJ11279;

import java.io.*;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class B11279_jjeonghak {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input == 0) {
				sb.append(Objects.isNull(pq.peek()) ? 0 : pq.poll()).append("\n");
			} else {
				pq.offer(input);
			}
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
