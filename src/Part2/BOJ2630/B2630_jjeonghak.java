package Part2.BOJ2630;

import java.io.*;
import java.util.Arrays;

public class B2630_jjeonghak {

	private static int zeroCnt, oneCnt;

	private static Integer[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		map = new Integer[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
					.map(Integer::parseInt)
					.toArray(Integer[]::new);
		}
		solution(0, 0, n);

		sb.append(zeroCnt).append("\n").append(oneCnt);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void solution(int x, int y, int n) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (!map[x][y].equals(map[i][j])) {
					solution(x, y, n / 2);
					solution(x + n / 2, y, n / 2);
					solution(x, y + n / 2, n / 2);
					solution(x + n / 2, y + n / 2, n / 2);
					return;
				}
			}
		}
		if (map[x][y] == 0) {
			zeroCnt++;
		} else {
			oneCnt++;
		}
	}

}
