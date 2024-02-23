import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    //백트랙킹 개념을 다 잊어먹은지 오래라 개념 다시 상기 시키고 풀었던 문제. 코드가 엄청 지저분한데 이제 코드를 클린하게 하는 연습이 필요할 듯

    public static void f(int num, int size, ArrayList<Boolean> chk, ArrayList<Integer> result, ArrayList<Integer> resultSum, ArrayList<Integer> arrNum){
        //백트랙킹 관련 코드
        if(num == size){
            int sum = 0;
            for(int i = 0;i<size-1;i++){
                sum += (Math.abs(result.get(i) - result.get(i+1)));
            }
            resultSum.add(sum);
            return;
        }
        
        for(int i = 1;i<=size;i++){
            if(chk.get(i) == false){
                chk.set(i, true);
                result.add(arrNum.get(i-1));
                f(num+1, size, chk, result, resultSum, arrNum);
                chk.set(i, false);
                result.remove(result.size()-1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrNum = new ArrayList<>();
        while(st.hasMoreTokens()){
            arrNum.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Boolean> chk = new ArrayList<Boolean>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> resultSum = new ArrayList<>();
        for(int i = 0;i<=size;i++){
            chk.add(false);
        }



        f(0, size, chk, result, resultSum, arrNum);

        System.out.println(Collections.max(resultSum));;
    }

}
