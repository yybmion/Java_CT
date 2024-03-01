import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663_kimjiheej {

    // 백트래킹 문제이다.

    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth){
        // 모든 원소를 다 채운 상태면 count 증가 및 return

        if(depth == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i;

            if(Possibility(depth)){
                nQueen(depth+1);
            }
        }
    }

    public static boolean Possibility(int col){
        for(int i=0; i<col; i++){
            if(arr[col] == arr[i]){
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {

                return false;
            }

            // 대각선상에 놓여있는 경우. 열의 차와 행의 차가 같으면 대각선에 놓여있다.
        }

        return true;
    }
}

/*
  참고 :  https://st-lab.tistory.com/118
 */
