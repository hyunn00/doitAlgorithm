package chap02;

import java.util.Scanner;

public class Ex3 {
    static int sumOf(int[] a) {
        int sum=0;
        for(int i=0; i<a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("배열 a의 모든 요소의 합계를 구하여 반환하는 메서드를 작성");
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();

        int[] x = new int[num];

        for(int i=0; i<num; i++) {
            System.out.print("x[" + i + "] :");
            x[i] = scanner.nextInt();
        }

        System.out.println("배열의 합 : " + sumOf(x));
    }
}
