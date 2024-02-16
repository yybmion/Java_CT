package Part1.BOJ1181;

import java.io.*;
import java.util.*;

public class B1181_jjeonghak {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Set<String> input = new HashSet<>();
		for (int i = 0; i < n; i++) {
			input.add(br.readLine());
		}
		input.stream()
				.sorted(
						Comparator.comparing(String::length)
								.thenComparing(String::compareTo)
				)
				.forEach(i -> sb.append(i).append("\n"));

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
