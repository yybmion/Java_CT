package Part1.BOJ2390;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2390_99hyeon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0;
        for(int i = 0; i < 9; i++){
            list.add(Integer.parseInt(br.readLine()));
            sum += list.get(i);
        }
        br.close();

        Loop1 :
        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 9; j++){
                if((sum - list.get(i) - list.get(j)) == 100){
                    list.remove(i);
                    list.remove(j-1);   //i번째 값을 지우기 때문에 j번째가 1칸 앞으로 당겨져서 j-1번째 값을 삭제함
                    break Loop1;    //이중 for문 나감
                }
            }
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}

/**
 * 문제에 9명 중 7명이 일곱 난쟁이라는 힌트를 얻을 수 있었다.
 * 따라서 9명 합 중 2명을 이중 for문을 돌려서 뺀 값이 100이 나오면
 * 일곱 난쟁이를 찾을 수 있었다.
 */