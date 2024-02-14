import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        ArrayList<Integer> arrNum = new ArrayList<>();
        int sum = 0;
        for(int i =0;i<9;i++){
            int input = Integer.parseInt(br.readLine());
            arrNum.add(input);
            
            sum+=input;
        }

        //문제 해결부분 (이중반복문을 이용해 문제 해결)
        breakLoop:
        for(int i=0;i<9;i++){
            int num1 = arrNum.get(i);
            for(int j=1;j<9;j++){
                int num2 = arrNum.get(j);

                if(i == j){
                    continue;
                }
                //두 개의 인덱스를 지정한 뒤에 전체합에 두 인덱스의 값을 뺄 시에 100이 나올 시 인덱스의 값을 제거하고 break 걸어줌
                else if(sum-(num1+num2)==100){
                    //앞에 있는 인덱스가 먼저 지워지게 되면은 뒤에 있는 인덱스는 앞에 있는 인덱스까지 계산해서 제거해줘야하기 때문에 if else문을 씀.
                    if(i > j){
                        arrNum.remove(i);
                        arrNum.remove(j);
                    }
                    else{
                        arrNum.remove(j);
                        arrNum.remove(i);
                    }
                    break breakLoop;
                }
            }
        }

        //collections를 이용한 리스트 정렬
        Collections.sort(arrNum);

        for(int i =0;i<7;i++){
            System.out.println(arrNum.get(i));
        }
    }
}
