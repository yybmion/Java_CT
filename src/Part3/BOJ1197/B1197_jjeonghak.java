package Part3.BOJ1197;

import java.io.*;
import java.util.*;

public class B1197_jjeonghak {

	private static int v, e;
	private static boolean[] check;
	private static final Map<Integer, List<Node>> map = new HashMap<>();
	private static final PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		v = Integer.parseInt(input[0]);
		e = Integer.parseInt(input[1]);
		check = new boolean[v + 1];
		for (int i = 0; i < e; i++) {
			initData(br.readLine().split(" "));
		}

		int result = 0;
		pq.offer(new Node(1, 0));
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			List<Node> nodes = map.get(node.index);

			if (check[node.index]) {
				continue;
			}
			check[node.index] = true;
			result += node.distance;

			for (Node next : nodes) {
				if (!check[next.index]) {
					pq.offer(new Node(next.index, next.distance));
				}
			}
		}

		sb.append(result);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void initData(String[] input) {
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);

		if (map.containsKey(a)) {
			map.get(a).add(new Node(b, c));
		} else {
			List<Node> list = new ArrayList<>();
			list.add(new Node(b, c));
			map.put(a, list);
		}
		if (map.containsKey(b)) {
			map.get(b).add(new Node(a, c));
		} else {
			List<Node> list = new ArrayList<>();
			list.add(new Node(a, c));
			map.put(b, list);
		}
	}

	private static class Node implements Comparable<Node> {
		private int index;
		private int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
	}

}
