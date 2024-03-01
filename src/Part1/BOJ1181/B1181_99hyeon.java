package Part1.BOJ1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B1181_99hyeon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String[] list = new String[num];

        for(int i = 0; i<num; i++){
            list[i] = br.readLine();
        }
        br.close();

        Arrays.sort(list, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                //2.사전 순 정렬
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }else{  //1.길이 순 정렬
                    return s1.length() - s2.length();
                }
            }
        });

        for(int i = 0; i < list.length; i++){
            if(i == 0){
                sb.append(list[i]).append("\n");
            }else if(list[i].equals(list[i-1])){    //중복 단어 제거
                continue;
            }else{
                sb.append(list[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}

/**
 * 이번 문제는 정렬 방식이 주 포인트인거 같다.
 * 1. 길이 순 정렬
 * 2. 길이 같을 시 사전 순 정렬
 *
 * 이 정렬을 위해 Arrays.sort의 comparator를 사용하였다.
 * return 값이 양수면 값을 바꾸고 아니면 그대로 가는 것을 이용하여
 * 길이가 같은 경우 compareTo를 사용해 값을 return해주었고
 * 길이가 다를 경우 길이값의 차를 이용해 값을 return해주어 정렬하였다.
 *
 * 그리고 중복된 값을 제거할 땐 앞의 단어와 비교하여 중복될 경우
 * StringBuilder에 추가하지않고 건너뛰는 방식으로 진행하였다.
 *
 * --------------------------------------------------------------------------
 *
 * 처음에는 Collections.sort()로 정렬하고 길이 순 정렬을 삽입 정렬 방식으로 풀었다.(중복제거는 위와 같은 방식으로 함)
 * 예제를 입력했을때는 맞게 출력이 되었다.
 * 하지만 백준에 입력했을 땐 계속 틀렸다고 떴다.
 * 왜 그런지는 이유를 아직 못 찾았다....
 * 왜... 틀렸는지 알고...싶..다....
 * 코드 남겨둘 걸 그랬다...ㅠ
 *
 */