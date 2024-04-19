package chap05;

import java.util.Scanner;

public class Ex3 {
    static int gcd(int x, int y) {
        while(x % y != 0) {
            int temp = x;
            x = y;
            y = temp % x;
        }
        return y;
    }

    static int gcdArray(int[] a, int start, int no) {
        if(no == 1) return a[start];
        else if(no == 2) return gcd(a[start], a[start+1]);
        else return gcd(a[start], gcdArray(a, start + 1, no - 1));
    }

    public static void main(String[] args) {
        System.out.println("배열 a의 모든 요소의 최대공약수를 구하는 다음 메서드를 작성하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("최대 몇 개의 최대 공약수를 구할까요? : ");
        int num;
        do {
            num = scanner.nextInt();
        } while(num <= 1);

        int[] x = new int[num];

        for(int i=0; i<num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        System.out.println("최대공약수는 " + gcdArray(x, 0, num) + "입니다.");
    }
}
