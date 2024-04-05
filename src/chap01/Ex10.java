package chap01;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        System.out.println("양의 정수를 입력하고 그 자릿수를 출력하는 프로그램을 작성하세요." +
                "예를 들어 135를 입력하면 '그 수는 3자리입니다.'라고 출력하고, 1314를 입력하면 '그 수는 4자리입니다.'라고 출력하면 됩니다.");

        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.println("n의 값");
            n = scanner.nextInt();
        } while(n <= 0);

        int no = 0;
        while (n > 0) {
            n /= 10;
            no++;
        }
        System.out.println("그 수는 "+no+"자리입니다.");
    }
}
