package Part2.BOJ16564;

import java.io.*;
import java.util.Arrays;

public class B16564_jjeonghak {

	private static int[] chars;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		chars = new int[n];
		for (int i = 0; i < n; i++) {
			chars[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(chars);

		long lb = chars[0];
		long rb = Integer.MAX_VALUE;
		long ans = lb;
		while (lb < rb) {
			long mid = (lb + rb) / 2L;
			long value = calculate(mid);

			if (value <= k) {
				lb = mid + 1;
				ans = mid;
			} else {
				rb = mid;
			}
		}

		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static long calculate(long h) {
		return Arrays.stream(chars)
				.mapToObj(Long::valueOf)
				.map(i -> h - i)
				.filter(i -> i > 0)
				.reduce(0L, Long::sum);
	}

}
