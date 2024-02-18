package Part2.BOJ2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2805_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stt1.nextToken());
        int M = Integer.parseInt(stt1.nextToken());
        int start=0;
        int mid=0;
        int end=0;
        int check=M;

        int[] arr = new int[N];

        StringTokenizer stt2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(stt2.nextToken());
        }

        Arrays.sort(arr);


         end = arr[N-1];

         while(start<end){
             mid = (start+end)/2;
             long sum = 0;
             for(int i=0;i<arr.length;i++){
                 if(mid<arr[i]){
                     sum = sum+(arr[i]-mid);
                 }
             }
             if(sum>check){
                 start = mid+1;
             }else if(sum<check){
                 end = mid;
             }else{
                 start=mid+1;
                 // 같을 때
             }
         }

        System.out.println(start-1);
    }
}


/**
 * 작성 예정
 */
