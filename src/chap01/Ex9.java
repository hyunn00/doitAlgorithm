package chap01;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        System.out.println("오른쪽과 같이 두 변수 a,b에 정수를 입력하고 b-a를 출력하는 프로그램을 작성하세요.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("a의 값 : ");
        int a = scanner.nextInt();
        int b;

        do {
            System.out.println("b의 값 : ");
            b = scanner.nextInt();
            if(b <= a) {
                System.out.println("a보다 큰 값을 입력하세요!");
            }
        } while(b <= a);

        System.out.println("b-a는 " + (b-a) + "입니다.");

    }
}
