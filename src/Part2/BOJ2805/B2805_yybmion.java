package Part2.BOJ2805;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2805_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stt1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stt1.nextToken());
        int M = Integer.parseInt(stt1.nextToken());
        int start=0;   // 이분탐색을 위한 변수 start,mid,end
        int mid=0;
        int end=0;
        int check=M;    // 필요한 나무 길이

        int[] arr = new int[N];

        StringTokenizer stt2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(stt2.nextToken());
        }

        Arrays.sort(arr);   // 사실 정렬 안해도 될것같긴한데, 제일 큰 값 고르려고 정렬함...

         end = arr[N-1];   // 제일 최대값을 end로 기준잡고 이분탐색 할거

         while(start<end){   // 이분탐색 시작
             mid = (start+end)/2;  // 중간값 잡기
             long sum = 0;  // int로 값 넘어갈까봐 long으로
             for(int i=0;i<arr.length;i++){
                 if(mid<arr[i]){                // mid값이 자르려는 나무보다 작을때 셈을 해야한다.
                     sum = sum+(arr[i]-mid);
                 }
             }
             if(sum>check){         // sum은 자르고 가져갈 나무인데 딱 값과 맞아야하므로 start,end,mid값을 이에 따라 조정해가며 구한다.
                 start = mid+1;
             }else if(sum<check){
                 end = mid;
             }else{
                 start=mid+1;
                 // 같을 때
             }
         }

         bw.write(start-1 + "");
         bw.flush();
    }
}


/**
 * 주석에 더해서 일단 위에서 말했듯 Arrays.sort는 굳이 하지 않아도 된다. 나중에 수정해야겠다...
 * 그리고 이게 이분탐색으로 풀지 않으면 아마 시간초과가 날것이다.
 * 나는 힌트를 통해 바로 이분탐색으로 풀었다.
 *
 * sum 즉, 가져갈 나무가 문제 입력의 값보다 크다면 너 크게 잘라야 sum이 낮아지므로 start값을 mid+1로 올려주고
 * 반대로 작다면 end를 mid로 낮춰주는것이다.
 * 어떤 의미인지는 아마 쉽게 알것이다.
 *
 * 마지막으로 같을 때도 start=mid+1인데 이 또한 최대값을 구해야 하기 때문이다.
 * 이분탐색에 대해서는 따로 투포인터와 비교하여 정리해서 올릴 예정이다.
 */
