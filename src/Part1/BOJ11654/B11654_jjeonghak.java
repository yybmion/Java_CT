package Part1.BOJ11654;

import java.io.*;

public class B11654_jjeonghak {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		sb.append((int)(br.readLine().charAt(0)));

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
