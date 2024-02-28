package Part2.BOJ2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110_llocr {
    static int[] house;
    static int n;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        house = new int[n];

        for(int i =0; i<n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int start = 1;
        int end = house[n-1];
        int result = 0;

        while(start <= end) {
            int mid = (start+end) / 2;

            if(check(mid) < c) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);
    }

    public static int check(int mid) {
        int count = 1;
        int last = house[0];

        for(int i = 1; i<house.length; i++) {
            int locate = house[i];

            if(locate - last >= mid) {
                count++;
                last = locate;
            }
        }

        return count;
    }
}

/*
* 어떻게 접근해야 좋을지 모르겠어서 머리를 싸맸다,,
* 가장 거리가 긴 순서대로 배치를 해볼까.. 중간부터 배치를 해볼까... 등등의 생각을 했지만
* 그런 방법으로는 규칙적으로 정답이 나오지 않는다는 걸 내가 직접 풀어보면서 깨닫게 되었고?
*
* 결국 풀이를 참고해서 답을 작성했다
* 풀이들에서는 공유기 사이의 "최소 거리"에 집중해서 문제를 진행시켰다
* 1번에는 무조건 설치를 한다고 가정할 때, 이분탐색으로 mid값을 설정하여 집 사이의 거리가 mid값보다 크다면 공유기를 설치하고
* 다시 공유기를 설치한 집에서부터 그 작업을 반복하여 마지막 집까지 탐색하여 설치 가능한 공유기 개수를 확인한다
*
* 설치 가능한 공유기 개수가 c값보다 크다면, 우리가 설정한 '최소 거리'를 늘린다
* 설치 가능한 공유기 개수가 c값보다 작다면, 우리가 설정한 '최소 거리'를 늘린다
* 설치 가능한 공유기 개수가 c갑과 같다고 하더라도, 이 '최소 거리'가 최대인지 알 수 없으니, 최소 거리를 늘리면서 이분탐색이 끝날 때까지 확인한다
* */