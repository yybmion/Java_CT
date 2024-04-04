package Part2.BOJ3190;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class B3190_jjeonghak {

	private static int n;
	private static int[] head = { 0, 0 };
	private static int[] tail = { 0, 0 };
	private static final int[] dx = { 0, 1, 0, -1 };
	private static final int[] dy = { 1, 0, -1, 0 };
	private static int[][][] map;
	private static final Map<Integer, Character> command = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		map = new int[n][n][2];
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			String[] input = br.readLine().split(" ");
			map[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1][0] = 1;
		}
		int l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			String[] input = br.readLine().split(" ");
			command.put(Integer.parseInt(input[0]), input[1].charAt(0));
		}

		changeMap(0, 0, -1, 0);
		sb.append(solution(1, 0));

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int solution(int time, int direction) {
		int nx = head[0] + dx[direction];
		int ny = head[1] + dy[direction];

		if ((nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) || (map[nx][ny][0] == -1)){
			return time;
		}

		boolean isApple = map[nx][ny][0] == 0;
		changeMap(nx, ny, -1, time);
		changeHeadAndTail(true, nx, ny);

		if (isApple) {
			int tailTime = Integer.MAX_VALUE;
			int tnx = tail[0];
			int tny = tail[1];
			changeMap(tnx, tny, 0, 0);

			for (int i = 0; i < 4; i++) {
				int tx = tail[0] + dx[i];
				int ty = tail[1] + dy[i];

				if (tx >= 0 && tx < n && ty >= 0 && ty < n && map[tx][ty][0] == -1) {
					if (tailTime > map[tx][ty][1]) {
						tailTime = map[tx][ty][1];
						tnx = tx;
						tny = ty;
					}
				}
			}
			changeHeadAndTail(false, tnx, tny);
		}
		if (command.containsKey(time)) {
			direction = changeDirection(direction, command.get(time));
		}
		return solution(time + 1, direction);
	}

	private static int changeDirection(int direction, char c) {
		if (c == 'L') {
			return direction = direction == 0 ? 3 : direction - 1;
		}
		return direction = direction == 3 ? 0 : direction + 1;
	}

	private static void changeMap(int x, int y, int value, int time) {
		map[x][y][0] = value;
		map[x][y][1] = time;
	}

	private static void changeHeadAndTail(boolean isHead, int x, int y) {
		if (isHead) {
			head[0] = x;
			head[1] = y;
		} else {
			tail[0] = x;
			tail[1] = y;
		}
	}

}
