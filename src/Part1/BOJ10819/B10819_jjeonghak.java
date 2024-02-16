package Part1.BOJ10819;

import java.io.*;
import java.util.*;

public class B10819_jjeonghak {

	private static int n, ans = Integer.MIN_VALUE;
	private static Integer[] input, result;
	private static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		check = new boolean[n];
		result = new Integer[n];
		input = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt)
				.toArray(Integer[]::new);
		bt(0);
		sb.append(ans);

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void bt(int index) {
		if (index == n) {
			int total = 0;
			for (int i = 1; i < n; i++) {
				total += Math.abs(result[i] - result[i - 1]);
			}
			ans = Math.max(ans, total);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				result[index] = input[i];
				bt(index + 1);
				check[i] = false;
				result[index] = null;
			}
		}
	}

}
