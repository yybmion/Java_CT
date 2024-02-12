package Part1.BOJ1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1181_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int j=0;
        String[] arr = new String[N];

        Sort[] sorts = new Sort[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            sorts[i] = new Sort(arr[i].length(), arr[i]);
        }

        Arrays.sort(sorts, comp);

        for(j=0;j<sorts.length-1;j++){
            if(sorts[j].dict.equals(sorts[j+1].dict)) continue;   // == 로 하면 왜 안될까?

            str.append(sorts[j].dict).append("\n");
        }
        str.append(sorts[j].dict).append("\n");

        System.out.println(str);

    }

    /**
     * Arrays.sort의 파라미터로 넣기 위한 (정렬 기준이 담긴) 익명 클래스 생성
     */
    static Comparator<Sort> comp = new Comparator<Sort>() {
        @Override
        public int compare(Sort o1, Sort o2) {
            if (o1.length == o2.length) {
                for (int i = 0; i < o1.length; i++) {
                    if (o1.dict.charAt(i) != o2.dict.charAt(i)) {
                        return (o1.dict.charAt(i)) - (o2.dict.charAt(i));
                    }
                }
            }
                return o1.length - o2.length;
        }
    };

    /**
     * 클래스 Sort
     * length : 문자열 길이
     * dict : 문자열
     */
    static class Sort{
        int length;
        String dict;

        public Sort(int length, String dict) {
            this.length = length;
            this.dict = dict;
        }
    }

}



/**
 * 정렬문제이다.
 * 조건은 두가지가 있는데 1.길이가 짧은것 부터 2. 길이가 같으면 사전 순으로 정렬해야한다.
 * 그래서 생각한 방법은 Sort 클래스를 만들어서 그 단어의 길이를 나타내는 length와 그 단어 자체를 저장하는 dict 변수를 가진 클래스를 생성했다.
 * Comparator을 Array.sort에 정렬기준을 파라미터로 넘기기 위해 익명 클래스를 사용했다.
 *
 * 정렬 기준은 다음과 같다.
 * 만약 길이가 같으면 문자열을 비교해서 다른 문자가 나올때까지 인덱스를 늘려간다.
 * 서로 다른 글자가 나올시 그 문자를 통해 사전 순으로 정렬하는 로직이다.
 *
 * 그 외에는 그냥 길이로 정렬한다. (return o1.length - o2.length;)
 *
 * 이후 정렬은 해주었는데 문제는 출력에서 중복된 문자열은 처리를 아직 못했다.
 * (sorts[j].dict.equals(sorts[j+1].dict)) 이 코드는 정렬은 되어있으니 앞에 문자열이 나와 같을 시 출력하지 않는다는 코드다.
 * 이렇게 중복제거를 하여 답을 구했다.
 *
 * Comparator과 Comparable에 대해서는 다음 블로그를 참고하면 좋다.
 * https://st-lab.tistory.com/243
 */

