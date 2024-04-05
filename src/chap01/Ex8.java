package chap01;

import java.util.Scanner;

public class Ex8 {
    static int sumOf(int a, int b) {
        int sum=0;
        //for문을 2번 작성하는 것보단 최소, 최댓값을 구하여 한번에 작성하는 것이 효율적
//        if(a <= b) {
//            for(int i = a; i<= b; i++) {
//                sum += i;
//            }
//        } else {
//            for(int i = a; i>=b; i--) {
//                sum += i;
//            }
//        }
        int min = 0;
        int max = 0;
        if(a<= b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
        for(int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("정수 a, b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 아래 메서드를 작성하세요.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("a의 값 : "); int a = scanner.nextInt();
        System.out.println("b의 값 : "); int b = scanner.nextInt();
        System.out.println("a + b의 값 : " + sumOf(a, b));
    }
}
