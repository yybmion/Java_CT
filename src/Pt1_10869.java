import java.io.*;
import java.util.StringTokenizer;

public class Pt1_10869 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(N+M)+"\n");
        bw.write(String.valueOf(N-M)+"\n");
        bw.write(String.valueOf(N*M)+"\n");
        bw.write(String.valueOf(N/M)+"\n");
        bw.write(String.valueOf(N%M)+"\n");

        bw.flush();

    }

}
