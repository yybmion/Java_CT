package Part1.BOJ2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B2869_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        int days = ((Z-A) / (A-B)) + 1;

        if((Z-A) % (A-B) != 0) days++;

        System.out.println(days);
    }
    public void firstSolution() {
        Scanner sc = new Scanner(System.in);
        int can = sc.nextInt();
        int slide = sc.nextInt();
        int high = sc.nextInt();
        int now = 0;
        int day = 1;

        while(now < high) {
            now += can;
            if(now >= high) break;
            now -= slide;
            if(now < 0) now = 0;
            day++;
        }

        System.out.println(day);
    }
}

/*
* 처음에는 시간 제한 신경 안 쓰고 얼레벌레 문제 풀었다가,, 그냥 망함
* 받을 게 별로 없으니 Scanner 써봤지만, Scanner가 시간을 엄청 잡아 먹어서 BufferedReader + StringTokenizer로 변경
*
* 1. 달팽이가 마지막날 오를 수 있는 것을 뺀 길이 (Z-A)에 하루에 오를 수 있는 길이 (A-B)를 나눠서 days를 구함
* 2. days에 마지막날 달팽이가 오르는 하루를 더함
* 3. 만약, (Z-A)%(A-B) != 0 이라면 -> 나머지가 있다면
*    days에 하루를 더해 줌
*
* */