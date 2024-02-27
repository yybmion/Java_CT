package Part2.BOJ2805;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B2805_jjeonghak {

	private static List<Long> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		list = Arrays.stream(br.readLine().split(" "))
				.map(Long::parseLong)
				.collect(Collectors.toList());

		long l = 0;
		long r = list.stream().max(Long::compareTo).get();
		long result = Long.MIN_VALUE;

		while (l < r) {
			long mid = (l + r) / 2;
			long total = search(mid);

			if (total < m) {
				r = mid;

			} else if (total >= m) {
				l = mid + 1;
				result = mid;
			}
		}

		sb.append(result);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static long search(long h) {
		return list.stream()
				.filter(i -> i > h)
				.map(i -> i - h)
				.reduce(0L, Long::sum);
	}

}
