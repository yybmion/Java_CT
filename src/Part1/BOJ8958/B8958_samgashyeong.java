import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        for(int i = 0;i<a;i++){
            String inputS = br.readLine();
            //각 입력마다의 합
            int sum = 0;
            //O가 맞출 때마다 하나씩 수가 올라가는 변수
            int stack = 1;
            for(int j = 0;j<inputS.length();j++){
                if(inputS.charAt(j) == 'O'){
                    sum+=stack;
                    stack++;
                }
                else{
                    stack = 1;
                }
            }
            System.out.println(sum);
        }
    }
}
