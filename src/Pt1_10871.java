import java.io.*;

public class Pt1_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());


        for(int i=0; i<N ; i++){
            int res = Integer.parseInt(bf.readLine());

            if(res < M) bw.write(String.valueOf(res));
        }

        bw.flush();
    }
}
