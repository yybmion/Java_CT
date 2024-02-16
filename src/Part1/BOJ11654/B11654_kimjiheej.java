import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11654_kimjiheej {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();

        char c = a.charAt(0);

        int k = (int)c;
        System.out.println(k);
    }
}
/*
  int 형으로 변환해서 그냥 풀어주면 되는 문제 !!
 */
