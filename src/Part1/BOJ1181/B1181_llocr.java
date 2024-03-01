package Part1.BOJ1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class B1181_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            String st = br.readLine();
            if(!list.contains(st)){
                list.add(st);
            }
        }

        Collections.sort(list, (o1, o2) -> {
            int check = o1.length() - o2.length();
            if(check == 0) {
                return o1.compareTo(o2);
            } else return check;
        });

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            sb.append(iterator.next()).append("\n");
        }

        System.out.println(sb);
    }
}

/*
* 문자열 길이에 대해서 sort하고, 그 이후에 사전 순으로 정렬하려고 하니 기본적인 메소드로는 해결을 못 할 것 같다는 생각을 했다!
* 그래서 Collections sort 부분을 새로 작성해서 문제를 풀었다
*
* Set을 사용해서 중복 확인하는 과정을 없앨까 했지만, set은 순서가 없기 때문에 그냥 ArrayList를 사용하고,
* List에 삽입하는 과정에서 이미 포함되어있다면 삽입하지 않는 것으로 해보았다..!
*
* 다른 분들 코드를 보니 같은 문제여도 되게 다양한 방식으로 접근하셔서 나도 참고할 부분이 많을 것 같다 :)
* */
