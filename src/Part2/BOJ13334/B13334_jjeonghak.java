package Part2.BOJ13334;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class B13334_jjeonghak {

	private static int n, d;
	private static List<Load> loads = new ArrayList<>();
	private static final PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			loads.add(new Load(input));
		}
		d = Integer.parseInt(br.readLine());
		loads = loads.stream().filter(l -> l.end - l.start <= d).sorted().collect(Collectors.toList());
		int result = 0;
		for (Load load : loads) {
			while(!pq.isEmpty() && load.end - pq.peek() > d) {
				pq.poll();
			}
			pq.offer(load.start);
			result = Math.max(result, pq.size());
		}
		sb.append(result);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static class Load implements Comparable<Load> {
		private int start;
		private int end;

		private Load(String[] input) {
			int i1 = Integer.parseInt(input[0]);
			int i2 = Integer.parseInt(input[1]);
			this.start = Math.min(i1, i2);
			this.end = Math.max(i1, i2);
		}

		@Override
		public int compareTo(Load o) {
			if (this.end != o.end) {
				return Integer.compare(this.end, o.end);
			}
			return Integer.compare(o.start, this.start);
		}
	}
}
