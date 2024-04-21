package chap06;

import java.util.Scanner;

public class Ex3 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubbleSort(int[] a, int n) {
        int compare = 0;
        int change = 0;
        for(int i=0; i<n-1; i++) {
            int exchg=0;
            System.out.printf("패스 %d :\n", (i + 1));
            for (int j = n - 1; j > i; j--) {
                compare++;
                for(int k=0; k<j-1; k++)
                    System.out.printf("%2d", a[k]);

                System.out.printf("%2d", a[j-1]);
                if (a[j - 1] > a[j]) {
                    System.out.print("+");
                    System.out.printf("%d", a[j]);
                    swap(a, j - 1, j);
                    exchg++;
                    change++;
                } else {
                    System.out.print("-");
                    System.out.printf("%d", a[j]);
                }
                for(int k=j+1; k<n; k++) {
                    System.out.printf("%2d", a[k]);
                }
                System.out.println();
            }
            for(int j=0; j<n; j++)
                System.out.printf("%2d", a[j]);
            System.out.println();

            if(exchg == 0) break;
        }

        System.out.printf("비교를 %d회 했습니다.\n", compare);
        System.out.printf("교환을 %d회 했습니다.\n", change);
    }

    public static void main(String[] args) {
        System.out.println("실습 6-2의 버블 정렬(버전 2)을 연습문제 Q2처럼 비교, 교환하는 과정을 자세히 출력하는 프로그램으로 수정하세요.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("버블 정렬(버전 2)");
        System.out.print("요솟수 : ");
        int nx = scanner.nextInt();
        int[] x = new int[nx];

        for(int i=0; i<nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        bubbleSort(x, nx);
    }
}
