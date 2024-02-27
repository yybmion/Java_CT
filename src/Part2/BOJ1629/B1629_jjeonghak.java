package Part2.BOJ1629;

import java.io.*;

public class B1629_jjeonghak {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		long a = Long.parseLong(input[0]);
		long b = Long.parseLong(input[1]);
		long c = Long.parseLong(input[2]);

		sb.append(calculate(a, b, c));
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static long calculate(long a, long b, long c) {
		if (b == 0) {
			return a;
		} else if (b == 1) {
			return a % c;
		} else if (b % 2 != 0) {
			return a * calculate(a, b - 1, c) % c;
		}
		long result = calculate(a, b / 2, c) % c;
		return result * result % c;
	}

}
