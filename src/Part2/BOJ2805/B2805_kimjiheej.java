import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이진 탐색 문제이다
public class B2805_kimjiheej {



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[a];

        st = new StringTokenizer(br.readLine());


        for(int i=0; i<a; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[a-1];
        int result = 0;

        while(start <=end)
        {
            int middle = (start+end)/2;

            long total = 0;

            for(int i=0; i<a; i++){
                if(arr[i] > middle) {
                    total += arr[i] - middle;
                }
            }

            if(total < b){ // 더 많이 잘라야 한다 값을
                end = middle - 1;
            }
            else {
                result = middle;
                start = middle + 1;
            }
        }

        System.out.print(result);

    }

}
/*
 이진 탐색 문제이다.
 total 을 long 으로 하지 않아서 틀렸다고 나왔었다.
 만약 계속 답이 틀리다면 자료형을 생각해보자.
 또한 result 를 사용하는 이유는 우리가 찾을 값을 result 로 해놓고
 최댓값을 구하는 것이기 때문에 total < b 일때에는 더 잘라야 하니 답이 되지 않고
 크거나 같아야 답이 된다.
 */
