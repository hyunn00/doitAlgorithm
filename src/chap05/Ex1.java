package chap05;

import java.util.Scanner;

public class Ex1 {
    // 음이 아닌 정수 n의 팩토리얼 값을 반환
    static int factorial(int n) {
        int fact = 1;
        for(int i=2; i<=n; i++)
            fact *= i;

//        while(n > 1)
//            fact *= n--;

        return fact;
    }

    public static void main(String[] args) {
        System.out.println("실습 5-1의 factorial 메서드를 재귀 메서드 호출을 사용하지 말고 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = scanner.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}
