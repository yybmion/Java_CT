package Part2.BOJ2110;

import java.io.*;
import java.util.Arrays;

public class B2110_jjeonghak {

	private static int n, c;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		c = Integer.parseInt(input[1]);
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arr = Arrays.stream(arr).sorted().toArray();

		int l = 1;
		int r = arr[n - 1] - arr[0] + 1;
		int result = Integer.MIN_VALUE;
		while (l < r) {
			int mid = (l + r) / 2;
			if (check(mid)) {
				l = mid + 1;
				result = mid;
			} else {
				r = mid;
			}
		}

		sb.append(result);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static boolean check(int dis) {
		int cnt = 1;
		int prev = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] - prev >= dis) {
				cnt++;
				prev = arr[i];
			}
		}
		return cnt >= c;
	}

}
