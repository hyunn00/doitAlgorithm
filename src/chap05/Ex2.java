package chap05;

import java.util.Scanner;

public class Ex2 {
    static int gcd(int x, int y) {
        while(x % y != 0) {
            int temp = x;
            x = y;
            y = temp % x;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println("실습 5-2의 gcd 메서드를 재귀 메서드 호출을 사용하지 말고 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요 : "); int x = scanner.nextInt();
        System.out.print("정수를 입력하세요 : "); int y = scanner.nextInt();

        System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
    }
}
