package Part2.BOJ2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2805_99hyeon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //값 입력 받음
        int[] list = new int[Integer.parseInt(st.nextToken())];
        int high = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < list.length; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(list);

        int min = 0;
        int max = list[list.length - 1];
        while(min < max){
            int mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < list.length; i++) {
                int check = list[i] - mid;
                if(check > 0){
                    sum += check;
                }
            }

            //상한가 조절
            if(sum < high){
                max = mid;
            }else { //하한가 조절
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}

/**
 *
 * 상한가와 하한가를 사용해서 문제를 풀었다.
 * 처음 나무를 자를 기준(mid)을 정할 때 제일 큰 나무의 반을 기준으로 정해서 계산하였다.(즉 하한가 = 0, 상한가 = 제일 큰 나무 길이)
 * 만약 자른 나무들의 합이 기준보다 크면 나무를 덜 잘라야 한다는 것이기 때문에 하한가를 올려서
 * 하한가를 mid + 1로 하여 다시 기준을 구하고
 * 만약 자른 나무들의 합이 기준보다 작으면 나무를 더 잘라야 하기 때문에 상한가를 낮춰서
 * 상한가를 mid로 두고 다시 기준을 구한다.
 *
 * -------------------------------------------------------------------------------------------
 *
 * 처음엔 하한가를 가장 짧은 나무로 하였는데 계속 틀렸다고 나왔다.
 * 제일 짧은 나무를 기준으로 하면
 * 제일 짧은 나무를 잘라야 원하는 나무 길이를 충족시킬 수 있는 경우를 만족시키지 못해 틀렸다고 나온 것이었다.
 *
 */

