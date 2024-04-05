package chap01;

import java.util.Scanner;

public class Ex15 {
    static void spira(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1;j<n +i ; j++) {
                if(j<=n-i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("n단의 피라미드를 출력하는 메서드를 작성하세요");

        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.println("몇 단의 피라미드 ?");
            n = scanner.nextInt();
        } while(n<=0);

        spira(n);
    }
}
