package chap01;

import java.util.Scanner;

public class Ex14 {
    static void triangleLB(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleLU(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(j <= n - i + 1)
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(j < i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRB(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(j<=n-i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("직각 이등변 삼각형을 출력하는 부분을 아래와 같은 형식의 메서드로 작성하세요.");

        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.println("몇 단의 삼각형을 만드실 건가요?");
            n = scanner.nextInt();
        } while(n <= 0);

        triangleLB(n);
        System.out.println();
        triangleLU(n);
        System.out.println();
        triangleRU(n);
        System.out.println();
        triangleRB(n);
    }
}
