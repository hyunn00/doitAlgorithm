package chap05;

import java.util.Scanner;

public class RecurX1 {
    // 음이 아닌 정수 n의 팩토리얼 값을 반환
    static void recur(int n) {
        while(n > 0) {
            recur(n - 1);
            System.out.println(n);
            n = n - 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = scanner.nextInt();

        recur(x);
    }
}
