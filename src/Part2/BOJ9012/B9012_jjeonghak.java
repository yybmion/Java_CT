package Part2.BOJ9012;

import java.io.*;

public class B9012_jjeonghak {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			sb.append(isVPS(br.readLine()) ? "YES\n" : "NO\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static boolean isVPS(String input) {
		char[] chars = input.toCharArray();
		int leftCnt = 0;

		for (char c : chars) {
			if (c == '(') {
				leftCnt++;
			} else {
				leftCnt--;
			}
			if (leftCnt < 0) {
				break;
			}
		}

		return leftCnt == 0;
	}

}
