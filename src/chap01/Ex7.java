package chap01;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        System.out.println("1부터 10까지의 합은 (1+10)*5와 같은 방법으로 구할 수 있습니다." +
                "가우스 덧셈이라는 방법을 이용하여 1부터 n까지의 정수 합을 구하는 프로그램을 작성하세요.");

        Scanner stdIn = new Scanner(System.in);
        System.out.println("n의 값 : ");
        int n = stdIn.nextInt();

        int sum = (1 + n) * (n / 2) + ((n % 2 == 1) ? (n + 1) / 2 : 0);
        // 홀수인 경우 나누기 2를 할 때 소수점 부분이 손실되는 것 때문에 손실된 부분을 추가로 더해줌

        System.out.println(sum);
    }
}
