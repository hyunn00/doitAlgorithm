package chap05;

import java.util.Scanner;

public class RecurX2 {
    // 음이 아닌 정수 n의 팩토리얼 값을 반환
    static void recur(int n) {
        IntStack s = new IntStack(n);

        while(true) {
            if (n > 0) {
                s.push(n);
                n = n - 1;
                continue;
            }

            if(!s.isEmpty()) {
                n = s.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = scanner.nextInt();

        recur(x);
    }
}
