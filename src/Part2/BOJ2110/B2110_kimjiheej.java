import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class B2110_kimjiheej {

    static int arr[];

    static int a;

    static int b;

    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         a = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());

        arr = new int[a];

        for(int i=0; i<a; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[a-1];
        int result = 0;


        while(start<=end){

            int middle = (start+end)/2; // 중간의 거리이다

            if(calculate(middle) < b){
                end = middle -1;
            }
            else {
                result = middle;
                start = middle+1;
            }
        }

        System.out.print(result);
    }

    public static int calculate(int d){
        int count = 1;
        int a = arr[0];

        for(int i=1; i<arr.length; i++){
            int k = arr[i];

            if(k - a >=d){
                count++;
                a = k;
            }
        }

        return count;
    }
}



