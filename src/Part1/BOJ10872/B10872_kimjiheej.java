import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10872_kimjiheej {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());


        System.out.println(fact(a));



    }

    public static int fact(int a){

        if(a==0)
            return 1;

        return a * fact(a-1);
    }
}
