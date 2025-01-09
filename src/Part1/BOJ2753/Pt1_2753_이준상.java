package Part1.BOJ2753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pt1_2753_이준상 {
    public static void main(String[] args) throws Exception {
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        

        if((a%4==0 && a%100!=0) || (a%4==0 && a%400==0)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
