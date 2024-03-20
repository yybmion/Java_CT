package Part3.BOJ1260;

import java.io.*;
import java.util.*;

public class B1260_jjeonghak {

	private static int n, m, v;
	private static boolean[] check;
	private static final StringBuilder sb = new StringBuilder();
	private static final Map<Integer, List<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		v = Integer.parseInt(input[2]);
		check = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			if (map.containsKey(a)) {
				map.get(a).add(b);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(b);
				map.put(a, list);
			}
			if (map.containsKey(b)) {
				map.get(b).add(a);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(a);
				map.put(b, list);
			}
		}

		dfs(v);
		sb.append("\n");
		bfs(v);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void dfs(int index) {
		check[index] = true;
		sb.append(index).append(" ");
		if (map.containsKey(index)) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(map.get(index));
			while(!pq.isEmpty()) {
				int next = pq.poll();
				if (!check[next]) {
					dfs(next);
				}
			}
		}
	}

	private static void bfs(int start) {
		Arrays.fill(check, false);
		check[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			int index = q.poll();
			sb.append(index).append(" ");
			if (map.containsKey(index)) {
				Collections.sort(map.get(index));
				for (int next : map.get(index)) {
					if (!check[next]) {
						check[next] = true;
						q.offer(next);
					}
				}
			}
		}
	}

}
