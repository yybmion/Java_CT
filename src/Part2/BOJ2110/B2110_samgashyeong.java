import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

//내 자신도 믿겨지지않지만, 골드 4의 문제를 원 트라이만에 맞춘 문제이다. 내 자신한테 칭찬을 하였던 순간.
public class B2110_samgashyeong {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(house);
        long max = 1000000001;

        long result = 0;
        long min = 0;

        while (max >= min) {
            long mid = (max + min) / 2;
            long cnt = 1;
            int idx = 0;
            for (int i = idx + 1; i < n; i++) {
                if (house[idx] + mid <= house[i]) {
                    cnt++;
                    idx = i;
                }
            }

            //System.out.println(cnt + " " + mid);
            if(cnt<c){
                max = mid-1;
                result = max;
            }
            else{
                min = mid+1;
            }
        }

        System.out.println(result);

    }
}