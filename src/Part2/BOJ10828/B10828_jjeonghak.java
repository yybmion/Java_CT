package Part2.BOJ10828;

import java.io.*;

public class B10828_jjeonghak {

	private static int[] element;
	private static int point;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		element = new int[n + 1];
		element[0] = -1;
		for (int i = 0; i < n; i++) {
			solution(br.readLine());
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void solution(String command) {
		if (command.startsWith("push")) {
			element[++point] = Integer.parseInt(command.split(" ")[1]);
		} else if (command.equals("pop")) {
			write(element[point--]);
		} else if (command.equals("size")) {
			write(point);
		} else if (command.equals("empty")) {
			write(point == 0 ? 1 : 0);
		} else if (command.equals("top")) {
			write(element[point]);
		}
		point = Math.max(point, 0);
	}

	private static void write(int result) {
		sb.append(result).append("\n");
	}

}
