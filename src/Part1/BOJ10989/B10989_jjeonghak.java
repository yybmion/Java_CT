package Part1.BOJ10989;

import java.io.*;

public class B10989_jjeonghak {

	private static int[] cnt = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 0; i < 10001; i++) {
			if (cnt[i] != 0) {
				for (int j = 0; j < cnt[i]; j++) {
					sb.append(i).append("\n");
				}
			}
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
