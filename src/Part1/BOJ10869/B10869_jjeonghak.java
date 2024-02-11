package Part1.BOJ10869;

import java.io.*;

public class B10869_jjeonghak {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);

		sb
			.append(a + b).append("\n")
			.append(a - b).append("\n")
			.append(a * b).append("\n")
			.append(a / b).append("\n")
			.append(a % b).append("\n");

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}

