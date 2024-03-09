package Part2.BOJ11866;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class B11866_jjeonghak {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}
		sb.append("<");
		int cnt = 1;
		while(!q.isEmpty()) {
			if (cnt == k) {
				sb.append(q.poll());
				if (!q.isEmpty()) {
					sb.append(", ");
				}
				cnt = 0;
			} else {
				q.offer(q.poll());
			}
			cnt++;
		}
		sb.append(">");

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
