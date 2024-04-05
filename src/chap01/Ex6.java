package chap01;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        System.out.println("실습 1-4에서 while문이 종료될 때 변수 i값이 n+1이 됨을 확인하세요" +
                "(변수 i값을 출력하도록 프로그램을 수정하세요");

        Scanner stdIn = new Scanner(System.in);
        System.out.println("n의 값 : ");
        int n = stdIn.nextInt();

        int sum = 0;
        int i = 1;

        while(i<= n) {
            sum += i;
            i++;
        }

        System.out.println("1부터 "+n+"까지의 합은 "+sum+"입니다.");
        System.out.println("i의 값 :" + i);
    }
}
