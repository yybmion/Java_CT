package Part2.BOJ2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2110_limjunhyuk97 {

    public static final int MAX_ROUTER_DIST = 1000000000;

    public static int N, C;

    public static int homes[];

    public static String inputs[];

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean isRouterDistAvailable(int maxDist) {
        int pivot = homes[0];
        int cnt = 1;

        for(int i=0; i<N; ++i) {
            if(homes[i] - pivot >= maxDist) {
                pivot = homes[i];
                cnt += 1;
            }
        }

        if(cnt >= C) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {

        // 입력
        inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        homes = new int[N];
        for(int i=0; i<N; ++i) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);

        // 이분탐색 전 l, r, m 세팅
        int left=1, right=MAX_ROUTER_DIST, mid=(left+right)>>1;

        // 이분탐색
        while(left <= right) {
            mid=(left+right)>>1;

            if(isRouterDistAvailable(mid)) {
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }

        System.out.println(right);
    }

}
