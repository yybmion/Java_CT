package Part2.BOJ2493;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class B2493_jjeonghak {

	private static int n;
	private static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		result = new int[n];
		List<Integer> input = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		PriorityQueue<Tuple> pq = new PriorityQueue<>();
		pq.offer(new Tuple(n - 1, input.get(n - 1)));

		for (int i = n - 1; i >= 0; i--) {
			int height = input.get(i);

			while (!pq.isEmpty()) {
				if (height < pq.peek().second) {
					break;
				}
				result[pq.poll().first] = i + 1;
			}

			pq.offer(new Tuple(i, height));
		}

		Arrays.stream(result).forEach(r -> sb.append(r).append(" "));
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static class Tuple implements Comparable<Tuple> {

		private Integer first;
		private Integer second;

		public Tuple(Integer first, Integer second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Tuple o) {
			if (!Objects.equals(this.second, o.second)) {
				return Integer.compare(this.second, o.second);
			}
			return Integer.compare(this.first, o.first);
		}

	}

}
