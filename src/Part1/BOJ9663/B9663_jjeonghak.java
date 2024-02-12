package Part1.BOJ9663;

import java.io.*;
import java.util.function.Function;

public class B9663_jjeonghak {

	private static final Function<Integer, Integer> IN = (x) -> x + 1;
	private static final Function<Integer, Integer> OUT = (x) -> x - 1;

	private static int n, result = 0;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		bt(0);
		sb.append(result);

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void bt(int depth) {
		if (depth == n) {
			result++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (map[i][depth] == 0) {
				check(IN, i, depth);
				bt(depth + 1);
				check(OUT, i, depth);
			}
		}
	}

	private static void check(Function<Integer, Integer> operator, int x, int y) {
		int width = 1;
		map[x][y] = operator.apply(map[x][y]);
		for (int i = y + 1; i < n; i++) {
			map[x][i] = operator.apply(map[x][i]);
			if (x - width >= 0) {
				map[x - width][i] = operator.apply(map[x - width][i]);
			}
			if (x + width < n) {
				map[x + width][i] = operator.apply(map[x + width][i]);
			}
			width++;
		}
	}

}

/**
 *
 * use backtracking
 *
 * check in - init method before search next depth
 *
 * check out - clear method
 *
 */
