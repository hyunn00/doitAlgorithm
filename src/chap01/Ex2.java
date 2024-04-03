package chap01;

import java.util.Scanner;

public class Ex2 {
    static int min3 (int a, int b, int c) {
        int min = a;
        if(b < min)
            min = b;
        if(c < min)
            min = c;

        return min;
    }

    public static void main(String[] args) {
        System.out.println("세 값의 최솟값을 구하는 min3 메서드를 작성하세요.");

        Scanner stdIn = new Scanner(System.in);

        System.out.println("a의 값 : ");
        int a = stdIn.nextInt();
        System.out.println("b의 값 : ");
        int b = stdIn.nextInt();
        System.out.println("c의 값 : ");
        int c = stdIn.nextInt();

        int min = min3(a, b, c);
        System.out.println(min);
    }
}
