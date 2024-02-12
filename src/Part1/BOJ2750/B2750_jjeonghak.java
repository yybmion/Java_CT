package Part1.BOJ2750;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class B2750_jjeonghak {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		Stream.generate(pq::poll)
				.limit(n)
				.forEach(i -> sb.append(i).append("\n"));

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
