package Part2.BOJ2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110_99hyeon {

    static int[] homeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int homeNum = Integer.parseInt(st.nextToken());
        int wifiNum = Integer.parseInt(st.nextToken());

        homeList = new int[homeNum];

        for(int i = 0; i < homeNum; i++){
            homeList[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(homeList);

        int min = 1;
        int max = homeList[homeNum - 1] - homeList[0] + 1;

        while(min < max){
            int mid = (min + max) / 2;

            if(canInstall(mid) < wifiNum){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }

    public static int canInstall(int distance){
        int count = 1;
        int lastInstall = 0;

        for(int i  = 0; i < homeList.length; i++){
            if(homeList[i] - homeList[lastInstall] >= distance){
                lastInstall = i;
                count++;
            }
        }
        return count;
    }
}

/**
 * 우선 공유기를 설치할 수 있는 최소거리 기준(mid = distance)을 정하고
 * (즉 공유기를 설치할 수 있는 최소거리를 2라고 하면 집의 좌표가 1인 집에 공유기를 설치했다면 집의 좌표가 3이상인 집부터 공유기를
 * 설치할 수 있다는 말이다.)
 * 그 기준을 가지고 canInstall이라는 함수를 사용해 공유기를 몇 대 설치할 수 있는지 확인하다.
 * canInstall의 반환값이 설치해야하는 공유기의 수(wifiNum)보다 작으면 거리를 줄여야 한다는 뜻이므로 max 값을 낮추고
 * canInstall의 반환값이 설치해야하는 고유기의 수(wifiNum)보다 많으면 거리를 늘려야 한다는 뜻이므로 min 값을 높인다.
 *
 * --------------------------------------------------------------------------------------------------
 *
 * 처음에 문제를 읽고 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치한다는 게 무슨 뜻인지 잘 몰랐다.
 * 아직도 저 문장만 보고는 이해가 잘 되지 않지만
 * https://st-lab.tistory.com/277
 * 위 사이트에서 설명을 잘 해주어서 이해를 할 수 있었다.
 */
